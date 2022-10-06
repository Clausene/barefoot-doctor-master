package com.clausene.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Clausene
 * @Title: EurekaMian7001
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 21:57
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMian7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMian7001.class);
    }
}
