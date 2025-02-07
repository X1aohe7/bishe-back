package com.it.medicine.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.common.entity.Medicine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineMapper extends BaseMapper<Medicine> {
    @Insert("INSERT INTO medicine_reminder_time (medicine_id, reminder_time) VALUES (#{medicineId}, #{time})")
    void insertReminderTime(@Param("medicineId") Long medicineId, @Param("time") String time);

    @Select("SELECT reminder_time FROM medicine_reminder_time WHERE medicine_id = #{medicineId}")
    List<String> getReminderTimesByMedicineId(@Param("medicineId") Long medicineId);

    @Delete("DELETE FROM medicine_reminder_time WHERE medicine_id = #{medicineId}")
    void deleteReminderTimesByMedicineId(@Param("medicineId") Long medicineId);
}
