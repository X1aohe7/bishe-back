package com.it.orders.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.common.entity.Orders;
import com.it.common.entity.User;
import com.it.orders.client.UserClient;
import com.it.orders.mapper.OrdersMapper;
import com.it.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UserClient userClient;

    @Override
    public Map<String, String> addOrders(Orders orders) {
        String s = IdUtil.simpleUUID();
        orders.setOrdersId(s);
        ordersMapper.insert(orders);

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("id", s);
        responseMap.put("message", "成功");

        return responseMap;
    }

    @Override
    public Orders getOrdersById(String id) {
        Orders orders = ordersMapper.selectById(id);
        return orders;
    }

    @Override
    public List<Orders> getAllOrdersByUserId(String uid) {
        LambdaQueryWrapper<Orders> orderLambdaQueryWrapper = Wrappers.lambdaQuery(Orders.class);
        orderLambdaQueryWrapper.eq(Orders::getUserId, uid).orderByDesc(Orders::getTime);
        List<Orders> orders = ordersMapper.selectList(orderLambdaQueryWrapper);
        return orders;
    }

    @Override
    public List<Orders> getAllOrdersByNursingId(String nursingId) {
        LambdaQueryWrapper<Orders> orderLambdaQueryWrapper = Wrappers.lambdaQuery(Orders.class);
        orderLambdaQueryWrapper.eq(Orders::getNursingId, nursingId);
        List<Orders> orders = ordersMapper.selectList(orderLambdaQueryWrapper);
//        for(Orders order : orders) {
//            User user = userClient.getUserById(Long.valueOf(order.getUserId()));
//            order.setName(user.getName());
//        }
        return orders;
    }



}
