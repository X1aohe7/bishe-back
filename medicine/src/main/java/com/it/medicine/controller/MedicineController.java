package com.it.medicine.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.common.entity.Medicine;
import com.it.medicine.mapper.MedicineMapper;
import com.it.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/medicine")
@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Medicine medicine){
//        medicineMapper.insert(medicine);
        medicineService.addMedicine(medicine);
        return ResponseEntity.ok("成功");
    }

    @GetMapping("/list")
    public ResponseEntity<List> getByUid(@RequestParam Integer uid) {
        List<Medicine> medicines = medicineService.getMedicineByUserId(uid);
//        LambdaQueryWrapper<Medicine> queryWrapper = Wrappers.lambdaQuery(Medicine.class);
//        queryWrapper.eq(Medicine::getUid, uid);
//        List<Medicine> medicines = medicineMapper.selectList(queryWrapper);
        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> get(@RequestParam Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        return ResponseEntity.ok(medicine);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> remove(@RequestParam Long id) {

        medicineService.deleteMedicine(id);
        return ResponseEntity.ok("成功");
    }
}
