package com.it.orders.client;


import com.it.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 指定目标服务的名称（必须与注册中心中的服务名一致）和路径
@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/user/getUserById")
    User getUserById(@RequestParam("id") Long id);
}
