package com.it.common.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户收藏护理表
 */

@Data
@TableName("user_nursing_collect")
public class UserNursingCollect {
    @TableId(type = IdType.AUTO)
    private Integer collectId;

    private Integer userId;

    private Integer nursingId;
}
