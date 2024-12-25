package com.it.common.entity;

import lombok.Data;

/**
 * 药物
 */
@Data
public class Medicine {

    private Long id;

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
