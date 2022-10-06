package com.clausene.outpatien.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Clausene
 * @Title: ApplictionContextConfig
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 18:17
 */
@Configuration
public class ApplictionContextZkConfig {

    /***
     * @author Clausene
     * @date 2022/10/2 18:19
     * @Description: 将RestTemplate注入到sprig容器中
     * @param:
     * @return org.springframework.web.client.RestTemplate
    */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
