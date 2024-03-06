package com.mk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.mk.cloud.mapper")
public class Payment {
    public static void main(String[] args) {
        SpringApplication.run(Payment.class, args);
    }
}
