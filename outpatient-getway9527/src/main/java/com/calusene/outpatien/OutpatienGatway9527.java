package com.calusene.outpatien;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: Clausene
 * @Title: OutpatienGatway9527
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/5 17:01
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class OutpatienGatway9527 {
    public static void main(String[] args) {
        SpringApplication.run(OutpatienGatway9527.class,args);
    }
}
