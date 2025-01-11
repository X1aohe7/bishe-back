package com.it.address.controller;


import com.it.address.service.AddressService;
import com.it.common.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer addressId) {
        boolean b = addressService.removeById(addressId);
        if (b) {
            return ResponseEntity.ok("成功");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除失败");
        }
    }

    @GetMapping("/getByAddressId")
    public ResponseEntity<Address> getById(@RequestParam Integer addressId) {
        Address address = addressService.getById(addressId);
        return ResponseEntity.ok(address);
    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Address address) {
        boolean b = addressService.updateById(address);
        if (b) {
            return ResponseEntity.ok("成功");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }
}
