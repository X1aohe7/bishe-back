package com.it.orders.controller;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.common.entity.Orders;
import com.it.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;



    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> add(@RequestBody Orders order){
//        String s = IdUtil.simpleUUID();
//        order.setId(s);
//        orderMapper.insert(order);
//
//        Map<String, String> responseMap = new HashMap<>();
//        responseMap.put("id", s);
//        responseMap.put("message", "成功");
        Map<String, String> responseMap = ordersService.addOrders(order);
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping("/get")
    public ResponseEntity<Orders> getByOrdersid(@RequestParam String id) {
//        Order order = orderMapper.selectById(id);
        Orders orders = ordersService.getOrdersByUserId(id);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/list")
    public ResponseEntity<List> list(@RequestParam String uid) {
//        LambdaQueryWrapper<Orders> orderLambdaQueryWrapper = Wrappers.lambdaQuery(Orders.class);
//        orderLambdaQueryWrapper.eq(Order::getUid, uid).orderByDesc(Orders::getTime);
//        List<Orders> orders = orderMapper.selectList(orderLambdaQueryWrapper);
        List<Orders> orders = ordersService.getAllOrdersByUserId(uid);
        return ResponseEntity.ok(orders);
    }

    /**
     * 查询护工订单
     * @param nid
     * @return
     */
    @GetMapping("/nur")
    public ResponseEntity<List> NurList(@RequestParam String nid) {
//        LambdaQueryWrapper<Order> orderLambdaQueryWrapper = Wrappers.lambdaQuery(Order.class);
//        orderLambdaQueryWrapper.eq(Order::getNid, nid);
//        List<Order> orders = orderMapper.selectList(orderLambdaQueryWrapper);
//        for(Order order : orders) {
//            User user = userMapper.selectById(order.getUid());
//            order.setName(user.getName());
//        }
        List<Orders> orders = ordersService.getAllOrdersByNursingId(nid);

        return ResponseEntity.ok(orders);
    }
}
