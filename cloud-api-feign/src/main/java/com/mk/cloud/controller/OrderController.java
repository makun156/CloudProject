package com.mk.cloud.controller;

import com.mk.cloud.apis.PayFeignApi;
import com.mk.cloud.entities.PayDTO;
import com.mk.cloud.response.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
public class OrderController {
    @Autowired
    private PayFeignApi payFeignApi;
    @PostMapping("/feign/pay/add")
    public ResultData<String> addPay(@RequestBody PayDTO payDTO) {
        System.out.println("feign调用add");
        return payFeignApi.add(payDTO);
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData<PayDTO> getById(@PathVariable("id") Integer id) {
        System.out.println("feign调用get");
        //输出当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前时间：" + sdf.format(new Date()));

        try {
            ResultData byId = payFeignApi.getById(id);
        } catch (Exception e) {
            System.out.println("当前时间：" + sdf.format(new Date()));

            e.printStackTrace();
        }
        return null;
    }



}
