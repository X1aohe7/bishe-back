package com.it.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 药物
 */
@TableName("medicine") // 对应数据库中的表名
@Data
public class Medicine {
    @TableId(type = IdType.AUTO)
    private Long medicineId;

    private String name;

    /**
     *  单次数量
     */
    private String num;

    /**
     * 用药次数
     */
    private String everyday;

    /**
     * 提醒时间
     */
    @TableField(exist = false)
    private List<String> reminderTime;

    /**
     * 用药时长
     */
    private String duration;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 创建时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;




}
