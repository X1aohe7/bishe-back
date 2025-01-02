package com.it.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
     * 提醒时间逗号隔开
     */
    private String time;

    /**
     * 用药时长
     */
    private String duration;

    /**
     * 用户id
     */
    private Long uid;




}
