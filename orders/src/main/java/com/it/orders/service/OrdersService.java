package com.it.orders.service;

import com.it.common.entity.Orders;

import java.util.List;
import java.util.Map;

public interface OrdersService {

    Map<String, String> addOrders(Orders orders);

    Orders getOrdersById(String id);

    List<Orders> getAllOrdersByUserId(String id);

    List<Orders> getAllOrdersByNursingId(String nursingId);


}
