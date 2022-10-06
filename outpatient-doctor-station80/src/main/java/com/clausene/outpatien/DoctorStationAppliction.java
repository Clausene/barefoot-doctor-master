package com.clausene.outpatien;

import com.clausene.rule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: Clausene
 * @Title: DoctorStationAppliction
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 18:03
 */
@SpringBootApplication
@EnableEurekaClient
// @RibbonClient(name = "OUTPATIENT-HALL",configuration = MyselfRule.class) // 自己编码负载算法时需要注释不然会报 No instances available for 192.168.2.111
public class DoctorStationAppliction {
    public static void main(String[] args) {

        SpringApplication.run(DoctorStationAppliction.class);
    }
}
