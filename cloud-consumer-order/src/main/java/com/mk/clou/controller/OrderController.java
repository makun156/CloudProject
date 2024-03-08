package com.mk.clou.controller;

import com.mk.cloud.entities.PayDTO;
import com.mk.cloud.response.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    public static final String Payment_URL="http://localhost:8001";
    @Resource
    public RestTemplate restTemplate;
    @PostMapping("/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(Payment_URL+"/pay/add",payDTO, ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData<PayDTO> getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(Payment_URL+"/pay/get/"+id,ResultData.class,id);

    }
}
