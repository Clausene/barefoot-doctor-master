package com.clausene.outpatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Clausene
 * @Title: OutpatientHall8004
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/3 12:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OutpatientHall8004 {
    public static void main(String[] args) {
        SpringApplication.run(OutpatientHall8004.class);
    }
}
