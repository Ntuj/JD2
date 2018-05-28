package com.bawei.jd2.net;


import com.bawei.jd2.bean.BaseBean;
import com.bawei.jd2.bean.OrdersBean;

import io.reactivex.Observable;

public class OrderApi {
    private static OrderApi orderApi;
    private OrderApiService orderApiService;

    private OrderApi(OrderApiService orderApiService) {
        this.orderApiService = orderApiService;
    }

    public static OrderApi getOrderApi(OrderApiService orderApiService) {
        if (orderApi == null) {
            orderApi = new OrderApi(orderApiService);
        }
        return orderApi;
    }

    public Observable<OrdersBean> getOrders(String uid, String page, String token) {
        return orderApiService.getOrders(uid, page, token);
    }

    public Observable<BaseBean> updateOrder(String uid, String status, String orderId, String token) {
        return orderApiService.updateOrder(uid, status, orderId, token);
    }
}
