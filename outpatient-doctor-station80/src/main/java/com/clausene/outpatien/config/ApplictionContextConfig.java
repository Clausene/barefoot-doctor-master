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
public class ApplictionContextConfig {

    /***
     * @author Clausene
     * @date 2022/10/2 18:19
     * @Description: 将RestTemplate注入到sprig容器中
     * 轮询算法： rest接口的请求第几次请求数 % 提供服务器集群总数 = 实际调用服务器位置下标，每次服务重启rest接口就从0开始计数
     *  提供服务的信息存在list 中
     * @param:
     * @return org.springframework.web.client.RestTemplate
    */
    @Bean
    //@LoadBalanced //让这个RestTemplate在请求时拥有客户端负载均衡的能力  //将此注解注释掉，使用自己的轮询算法不使用默认的
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
