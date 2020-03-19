package com.pger.de.state.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;


/**
 *
 * 订单状态机配置
 *  含持久化操作
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStatusMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {

    /**
     *
     * 配置状态
     *
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states) throws Exception {
        states.withStates().initial(OrderStatus.WAIT_PAYMENT).states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param config
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions) throws Exception {
        // 待付款 -- 待发货 ，事情驱动：付款
        transitions.withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                // 待发货 -- 待收货 ，事件驱动：发货
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                // 待收货 -- 订单结束，事件驱动：收货
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    /**
     *
     * 持久化配置
     *  可配置成redis、mysql等持久化操作
     *
     * @return
     */
    @Bean
    public DefaultStateMachinePersister persister() {
        return new DefaultStateMachinePersister(new StateMachinePersist<Object, Object, Order>() {
            public void write(StateMachineContext<Object, Object> context, Order order) throws Exception {
                // 持久化配置
            }

            public StateMachineContext read(Order order) throws Exception {
                // 获取order中的状态，需要持久化操作
                return new DefaultStateMachineContext(order.getStatus(), null, null, null);
            }
        });
    }


}
