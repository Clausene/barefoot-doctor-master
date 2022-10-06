package com.clausene.outpatien.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Clausene
 * @Title: FeignConfig
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 10:43
 */
@Configuration
public class FeignConfig {

    /**
     * @author Clausene
     * @date 2022/10/4 10:45
     * @Description: 设置feign 日志级别
     * @param:
     * @return feign.Logger.Level
    */
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
