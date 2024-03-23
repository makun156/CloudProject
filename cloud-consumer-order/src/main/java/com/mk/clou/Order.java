package com.mk.clou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class Order {
    public static LocalDate getFirstDayOfMonth(YearMonth yearMonth) {
        return yearMonth.atDay(1);
    }

    public static void main(String[] args) {
        SpringApplication.run(Order.class, args);
        //YearMonth input = YearMonth.of(2024, 3); // 输入年份为2024，月份为3（即三月）
        //LocalDate firstDayOfMonth = getFirstDayOfMonth(input);
        //System.out.println(firstDayOfMonth+"==="+input.atEndOfMonth());
    }
}
