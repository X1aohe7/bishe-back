package com.it.common.entity;



import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 护理人员信息
 */
@Data
public class Nursing {

    private Integer nid;
    /**
     * 护理人员名称
     */
    private String nurseName;

    /**
     * 护理人员年龄
     */
    private Integer age;

    /**
     * 护理人员省份
     */
    private String province;

    /**
     * 从业时间
     */
    private Integer employmentTime;

    /**
     * 介绍
     */
    private String introduction;

    private Double price;

    /**
     * 关注数量
     */
    private Integer followed;
//
//    @TableField(exist = false)
    private String query;


//    @TableField(exist = false)
    private List<Skill> skillList=new ArrayList<>();


    public void addList(Skill s){
        if(s!=null) {
            skillList.add(s);
        }
    }

}
