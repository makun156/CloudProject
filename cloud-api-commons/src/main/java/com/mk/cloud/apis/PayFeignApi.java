package com.mk.cloud.apis;

import com.mk.cloud.entities.PayDTO;
import com.mk.cloud.response.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData add(@RequestBody PayDTO payDTO);
    @GetMapping("/pay/get/{id}")
    ResultData getById(@PathVariable("id") Integer id);
}
