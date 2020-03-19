package com.pger.de.state.order;

/**
 * 订单状态
 */
public enum OrderStatus {
    // 待支付
    WAIT_PAYMENT,
    // 待发货
    WAIT_DELIVER,
    // 待收货
    WAIT_RECEIVE,
    // 订单结束
    FINISH;

}
