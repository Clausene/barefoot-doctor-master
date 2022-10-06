package com.clausene.outpatient.controller;

import com.clausene.outpatien.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: Clausene
 * @Title: PaymentZkController
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/3 16:48
 */
@RestController
@RequestMapping("/payment")
public class PaymentZkController {

    @Value("${server.port}")
    private String port;
    @RequestMapping("/getZkInfo")
    public CommonResult getZkInfo(){
        return new CommonResult(200,"查询成功,端口:"+ port, UUID.randomUUID());
    }
}
