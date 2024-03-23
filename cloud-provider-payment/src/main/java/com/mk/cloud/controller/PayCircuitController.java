package com.mk.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class PayCircuitController {
    @GetMapping("/pay/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id) {
        if(id<=0){
            throw new RuntimeException("id不能为负");
        }
        if (id==9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello world"+ IdUtil.simpleUUID();
    }

    /**
     * 舱壁模式例子
     * @param id
     * @return
     */
    @GetMapping("/pay/bulkhead/{id}")
    public String bulkhead(@PathVariable("id") Integer id) {
        if(id<=0){
            throw new RuntimeException("id不能为负");
        }
        if (id==9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello world bulkhead"+"id===>"+id+"==="+ IdUtil.simpleUUID();
    }
}
