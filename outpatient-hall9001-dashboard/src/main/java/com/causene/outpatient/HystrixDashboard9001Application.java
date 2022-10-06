package com.causene.outpatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: Clausene
 * @Title: HystrixDashboard9001Application
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 23:24
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001Application.class,args);
    }
}
