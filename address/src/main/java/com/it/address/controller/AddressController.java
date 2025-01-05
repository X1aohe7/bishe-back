package com.it.address.controller;


import com.it.address.service.AddressService;
import com.it.common.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Address address){
        addressService.save(address);
        return ResponseEntity.ok("成功");
    }

    @GetMapping("/get")
    public ResponseEntity<List> getByUid(@RequestParam Integer uid) {
        List<Address> list = addressService.findByUid(uid);
        return ResponseEntity.ok(list);
    }
}
