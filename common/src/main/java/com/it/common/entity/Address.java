package com.it.common.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 地址表
 */

@Data
@TableName("address") // 对应数据库中的表名
public class Address {
    @TableId(type = IdType.AUTO)
    private Integer addressId;

    private String position;

    private String detail;

    private String name;

    private String phone;

    private Integer userId;
}
