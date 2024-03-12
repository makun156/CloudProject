package com.mk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
//开启feign客户端
@EnableFeignClients
//该注解开启服务发现，将当前服务注册到consul注册中心
@EnableDiscoveryClient
public class Feign {
    public static void main(String[] args) {
        SpringApplication.run(Feign.class, args);
    }
}
