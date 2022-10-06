package com.clausene.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Clausene
 * @Title: EurekaMain7002
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 23:48
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class);
    }
}
