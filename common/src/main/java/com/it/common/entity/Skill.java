package com.it.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("skill")
public class Skill {
    @TableId(type = IdType.AUTO)
    private int skillId;
    private String skillName;
}
