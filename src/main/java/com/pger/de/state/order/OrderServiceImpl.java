package com.pger.de.state.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStatusMachine;

    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;

    private int id = 1;
    private Map<Integer, Order> orders = new HashMap<Integer, Order>();

    public Order create() {
        Order order = new Order();
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id++);
        orders.put(order.getId(), order);
        return order;
    }

    public Order pay(int id) {
        Order order = orders.get(id);
        System.out.printf("线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.printf("线程名称：" + Thread.currentThread().getName() + " 支付失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Order deliver(int id) {
        Order order = orders.get(id);
        System.out.printf("线程名称：" + Thread.currentThread().getName() + " 尝试发货，订单号：" + id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.printf("线程名称：" + Thread.currentThread().getName() + " 发货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }

    public Order receive(int id) {
        Order order = orders.get(id);
        System.out.printf("线程名称：" + Thread.currentThread().getName() + " 尝试收货，订单号：" + id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.printf("线程名称：" + Thread.currentThread().getName() + " 说活失败，状态异常，订单编号：" + id);
        }
        return orders.get(id);
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }


    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            // 状态机启动
            orderStatusMachine.start();

            // 尝试恢复状态机状态
            persister.restore(orderStatusMachine, order);
            
            // 添加延迟用于线程安全测试
            Thread.sleep(100);
            result = orderStatusMachine.sendEvent(message);

            // 持久化状态机状态
            persister.persist(orderStatusMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStatusMachine.stop();
        }
        return result;
    }

}
