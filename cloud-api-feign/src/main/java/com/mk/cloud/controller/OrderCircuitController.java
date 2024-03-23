package com.mk.cloud.controller;

import com.mk.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class OrderCircuitController {
    @Autowired
    private PayFeignApi payFeignApi;
    @GetMapping("/feign/pay/circuit/{id}")
    //name 要和yml文件中的自定义实例名一致
    // fallbackMethod服务降级方法
    //服务熔断，断路器
    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod = "myCustomFallbackMethod")
    public String myCustomCircuitMethod(@PathVariable("id") Integer id){
        return payFeignApi.circuit(id);
    }
    public String myCustomFallbackMethod(Integer id,Throwable t){
        return "系统繁忙，请稍后再试！";
    }

    /**
     * 舱壁，隔离，信号量模式
     * @param id
     * @return
     */
    //@GetMapping("/feign/pay/bulkhead/{id}")
    //// name=? 哪个远程调用要使用bulkhead舱壁隔离模式，fallbackMethod=服务降级方法，type 舱壁隔离模式
    //@Bulkhead(name = "cloud-payment-service",fallbackMethod = "myCustomBulkheadFallbackMethod",type = Bulkhead.Type.SEMAPHORE)
    //public String myCustomBulkheadMethod(@PathVariable("id") Integer id){
    //    return payFeignApi.bulkhead(id);
    //}
    //public String myCustomBulkheadFallbackMethod(Integer id,Throwable t){
    //    return "系统繁忙，请稍后再试！";
    //}

    /**
     * 舱壁，隔离，threadPool模式
     * @param id
     * @return
     */
    @GetMapping("/feign/pay/bulkhead/{id}")
    // name=? 哪个远程调用要使用bulkhead舱壁隔离模式，fallbackMethod=服务降级方法，type 舱壁隔离模式
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myCustomBulkheadFallbackMethod",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myCustomBulkheadMethod(@PathVariable("id") Integer id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.supplyAsync(()-> payFeignApi.circuit(id));
    }
    public CompletableFuture<String> myCustomBulkheadFallbackMethod(Integer id,Throwable t){
        return CompletableFuture.supplyAsync(()->"系统繁忙，请稍后再试！");
    }

    @GetMapping("/feign/pay/ratelimiter/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myCustomRateLimiterFallbackMethod")
    public String myCustomRateLimiterMethod(@PathVariable("id") Integer id){
        return payFeignApi.circuit(id);
    }
    public String myCustomRateLimiterFallbackMethod(Integer id,Throwable t){
        return "系统繁忙，请稍后再试！";
    }
}
