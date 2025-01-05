package com.it.common.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("orders")
public class Orders {

    @TableId(type = IdType.AUTO)
    private String ordersId;

    private String address;

    private Date time;

    private Integer userId;

    private Integer nursingId;

    private String nurName;


    private String name;

    private String remark;
}
