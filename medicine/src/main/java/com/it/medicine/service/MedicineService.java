package com.it.medicine.service;

import com.it.common.entity.Medicine;

import java.util.List;

public interface MedicineService {
    Boolean addMedicine(Medicine medicine);

    Boolean deleteMedicine(Long id);

    Boolean updateMedicine(Medicine medicine);

    Medicine getMedicineById(Long id);

    List<Medicine> getMedicineByUserId(Integer userId);
}
