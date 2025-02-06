package com.it.common.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("orders")
public class Orders {

    @TableId(type = IdType.AUTO)
    private String ordersId;

    private Integer addressId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private Integer userId;

    private Integer nursingId;

    private String nurName;

    private String remark;

    private Double price;
    
}
