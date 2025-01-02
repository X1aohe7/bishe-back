package com.it.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.common.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {
}
