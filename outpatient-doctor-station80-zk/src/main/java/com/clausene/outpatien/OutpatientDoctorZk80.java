package com.clausene.outpatien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: Clausene
 * @Title: OutpatientDoctorZk80
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/3 16:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OutpatientDoctorZk80 {

    public static void main(String[] args) {
        SpringApplication.run(OutpatientDoctorZk80.class,args);
    }
}
