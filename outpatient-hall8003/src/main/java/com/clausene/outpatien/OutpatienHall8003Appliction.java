package com.clausene.outpatien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient // 开启服务注册
@EnableDiscoveryClient // 开启服务发现
public class OutpatienHall8003Appliction {
    public static void main(String[] args) {
        SpringApplication.run(OutpatienHall8003Appliction.class);
    }
}
