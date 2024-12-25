package com.it.common.entity;

import lombok.Data;

/**
 * 用户表
 */

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String age;
    private Integer nid;
}
