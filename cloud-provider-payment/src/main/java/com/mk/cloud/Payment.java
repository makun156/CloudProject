package com.mk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@MapperScan("com.mk.cloud.mapper")
public class Payment {
    public static void main(String[] args) {
        //AtomicInteger num = new AtomicInteger(1);
        //List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //numbers.stream().forEach(n -> num.set(num.get() * n)); // 这里尝试修改num
        //
        //System.out.println(num.get()); // 结果可能仍然是1，而不是预期的120
        SpringApplication.run(Payment.class, args);
    }
}
