package com.it.nursing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@SpringBootApplication
@MapperScan("com.it.nursing.mapper")
public class NursingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NursingApplication.class, args);
    }

}
