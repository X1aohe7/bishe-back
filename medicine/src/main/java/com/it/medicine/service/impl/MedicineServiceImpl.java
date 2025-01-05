package com.it.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.common.entity.Medicine;
import com.it.medicine.mapper.MedicineMapper;
import com.it.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public Boolean addMedicine(Medicine medicine) {
        return null;
    }

    @Override
    public Boolean deleteMedicine(Long id) {
        medicineMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateMedicine(Medicine medicine) {
        return null;
    }

    @Override
    public Medicine getMedicineById(Long id) {
        Medicine medicine = medicineMapper.selectById(id);
        return medicine;
    }

    @Override
    public List<Medicine> getMedicineByUserId(Integer userId) {
        LambdaQueryWrapper<Medicine> queryWrapper = Wrappers.lambdaQuery(Medicine.class);
        queryWrapper.eq(Medicine::getUserId, userId);
        List<Medicine> medicines = medicineMapper.selectList(queryWrapper);
        return medicines;
    }
}
