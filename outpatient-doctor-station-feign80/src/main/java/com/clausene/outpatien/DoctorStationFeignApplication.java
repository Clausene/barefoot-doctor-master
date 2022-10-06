package com.clausene.outpatien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: Clausene
 * @Title: DoctorStationFeignApplication
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 10:00
 */
@SpringBootApplication
// 添加开启feign 注解
@EnableFeignClients
public class DoctorStationFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoctorStationFeignApplication.class,args);
    }
}
