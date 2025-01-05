package com.it.collect.client;

import com.it.common.entity.Nursing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nursing") // 修改为实际的服务地址
public interface NursingServiceClient {
    @GetMapping("/nurse/getNurseById")
    Nursing getNurseById(@RequestParam("id")Integer id);
}
