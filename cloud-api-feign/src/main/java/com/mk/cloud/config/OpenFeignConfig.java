package com.mk.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {
    //重试机制
    @Bean
    public Retryer retryer(){
        /** 失败重试机制
         * 1000表示重试的间隔时间（毫秒）
         * 5000表示最大重试间隔时间（毫秒）
         * 3表示最大重试次数
         */
        //return new Retryer.Default(1000, 5000, 3);
        return Retryer.NEVER_RETRY;
    }

    /**
     * openfeign打印日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
