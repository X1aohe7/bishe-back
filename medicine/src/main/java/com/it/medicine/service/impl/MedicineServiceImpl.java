package com.it.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.common.entity.Medicine;
import com.it.medicine.mapper.MedicineMapper;
import com.it.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;

    @Override
    public Boolean addMedicine(Medicine medicine) {
        // 插入 medicine 记录
        this.save(medicine);

        // 插入 medicine_reminder_time 记录
        for (String time : medicine.getReminderTime()) {
            medicineMapper.insertReminderTime(medicine.getMedicineId(), time);
        }
        return true;
    }
    @Transactional
    @Override
    public Boolean deleteMedicine(Long id) {
        // 先删除提醒时间
        medicineMapper.deleteReminderTimesByMedicineId(id);
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
        if (medicine != null) {
            // 查询提醒时间
            List<String> reminderTimes = medicineMapper.getReminderTimesByMedicineId(id);
            medicine.setReminderTime(reminderTimes);
        }
        return medicine;
    }

    @Override
    public List<Medicine> getMedicineByUserId(Integer userId) {
        LambdaQueryWrapper<Medicine> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Medicine::getUserId, userId);

        List<Medicine> medicines = medicineMapper.selectList(queryWrapper);

        // 查询每个药物的提醒时间，并设置到 Medicine 对象中
        return medicines.stream().peek(medicine -> {
            List<String> reminderTimes = medicineMapper.getReminderTimesByMedicineId(medicine.getMedicineId());
            medicine.setReminderTime(reminderTimes);
        }).collect(Collectors.toList());
    }
}
