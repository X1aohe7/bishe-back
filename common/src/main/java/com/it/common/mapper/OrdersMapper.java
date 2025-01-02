package com.it.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.common.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
