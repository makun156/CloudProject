package com.mk.cloud.controller;

import com.mk.cloud.entities.Pay;
import com.mk.cloud.entities.PayDTO;
import com.mk.cloud.response.ResultData;
import com.mk.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        log.info("addPay:{}", pay);
        int addRes = payService.add(pay);
        return ResultData.success("成功插入记录，返回值" + addRes);
    }

    @PostMapping("/pay/delete/{id}")
    public ResultData<String> deletePay(@PathVariable("id") Integer id) {
        log.info("deletePay:{}", id);
        int deleteRes = payService.delete(id);
        return ResultData.success("成功删除记录，返回值" + deleteRes);
    }

    @PostMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        log.info("updatePay:{}", payDTO);
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int updateRes = payService.update(pay);
        return ResultData.success("成功更新记录，返回值" + updateRes);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<PayDTO> getById(@PathVariable("id") Integer id) {
        System.out.println("openfeign调用了");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("getById:{}", id);
        Pay pay = payService.getById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(pay, payDTO);
        return ResultData.success(payDTO);
    }

    @GetMapping("/pay/getAll")
    public ResultData<List<PayDTO>> getAll() {
        log.info("getAll");
        List<Pay> payList = payService.getAll();
        List<PayDTO> payDTOList = payList.stream().map(pay -> {
            PayDTO payDTO = new PayDTO();
            BeanUtils.copyProperties(pay, payDTO);
            return payDTO;
        }).toList();
        return ResultData.success(payDTOList);
    }

    @Value("${server.port}")
    public String port;

    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${mk.info}") String info) {
        log.error("getInfoByConsul:{},{}", info,port);
        return info;
    }
}
