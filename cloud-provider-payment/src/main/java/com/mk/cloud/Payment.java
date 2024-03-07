package com.mk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@MapperScan("com.mk.cloud.mapper")
public class Payment {
    public static void main(String[] args) {
        SpringApplication.run(Payment.class, args);
    }
}
