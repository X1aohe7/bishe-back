package com.it.common.entity;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户评价记录表
 */

@Data
@TableName("user_nursing_comment")
public class UserNursingComment {

    @TableId(type = IdType.AUTO)
    private Integer commentId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 护理人员id
     */
    private Integer nursingId;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @TableField(exist = false)
    private String username;

    private String ordersId;
}
