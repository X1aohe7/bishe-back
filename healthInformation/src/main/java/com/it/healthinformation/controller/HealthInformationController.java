package com.it.healthinformation.controller;


import com.it.common.entity.HealthInformation;
import com.it.healthinformation.service.HealthInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/healthInformation")
public class HealthInformationController {
    @Autowired
    private HealthInformationService healthInformationService;

    @GetMapping("/getByPage")
    public ResponseEntity<Object> getHealthInformationByPage(@RequestParam int currentPage, @RequestParam int pageSize){
//        healthInformationService.getTotal();
//        return healthInformationService.getHealthInformationProfileByPage(currentPage,pageSize);

        long total = healthInformationService.getTotal();  // Get total count
        List<HealthInformation> healthInformationList = healthInformationService.getHealthInformationProfileByPage(currentPage, pageSize);  // Get data list
        // Create a Map to hold total and list
        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("list", healthInformationList);

        // Return ResponseEntity with the result and OK status
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get")
    public HealthInformation getHealthInformationDetail(@RequestParam int id){
        return healthInformationService.getHealthInformationDetail(id);
    }
}
