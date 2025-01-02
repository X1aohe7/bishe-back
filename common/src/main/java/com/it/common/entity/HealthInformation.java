package com.it.common.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("health_information")
public class HealthInformation {
    @TableId(type = IdType.AUTO)
    private Integer healthInformationId;

    private String profile;

    private String detail;

    private LocalDate time;
}
