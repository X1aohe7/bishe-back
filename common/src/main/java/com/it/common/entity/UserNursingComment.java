package com.it.common.entity;

//import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户评价记录表
 */

@Data
public class UserNursingComment {

    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 护理人员id
     */
    private Integer nid;

    /**
     * 评价内容
     */
    private String comment;

    /**
     * 评价星级
     */
    private String star;

    /**
     * 评价时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;

//    @TableField(exist = false)
    private String userName;
}
