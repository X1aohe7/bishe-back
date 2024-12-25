package com.it.common.entity;


import lombok.Data;

import java.util.Date;

@Data

public class Order {

    private String id;

    private String address;

    private Date time;

    private Integer uid;

    private Integer nid;

    private String nurName;


    private String name;

    private String remark;
}
