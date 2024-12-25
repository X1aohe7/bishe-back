package com.it.common.entity;


import lombok.Data;

import java.time.LocalDate;

@Data

public class HealthInformation {

    private Integer id;

    private String profile;
    private String detail;
    private LocalDate time;
}
