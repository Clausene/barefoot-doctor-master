package com.clausene.outpatient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: Clausene
 * @Title: OutpatientConfigApplication
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/6 11:29
 */
@SpringBootApplication
@EnableConfigServer
@Slf4j
public class OutpatientConfigApplication3344 {

    public static void main(String[] args) {
        SpringApplication.run(OutpatientConfigApplication3344.class,args);
        log.info("配置中心启动");
    }
}
