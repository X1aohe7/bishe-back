package com.it.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 */

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String username;
    private String password;
    private String name;
    private String age;
    private Integer nursingId;
}
