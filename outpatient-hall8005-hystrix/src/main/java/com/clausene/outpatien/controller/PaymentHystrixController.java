package com.clausene.outpatien.controller;

import com.clausene.outpatien.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clausene.outpatien.entities.CommonResult;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: Clausene
 * @Title: PaymentHystrixController
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 11:51
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentHystrixController {
    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/getPaymentInfoOk")
    public CommonResult getPaymentInfoOk(){
        return new CommonResult(200,"查询成功,端口:"+ port,null);
    }

    @GetMapping(value = "/getPaymentInfoTimeout")
    public CommonResult getPaymentInfoTimeout(){
        String result = paymentHystrixService.getPaymentInfoTimeout();
        return new CommonResult(200,"查询成功,端口:"+ port,result);
    }
    @GetMapping(value = "/getPaymentForCircuit/{id}")
    public CommonResult getPaymentForCircuit(@PathVariable("id") Long id){
        String result = paymentHystrixService.getPaymentForCircuit(id);
        log.info("断路器返回的结果：{}",result);
        return new CommonResult(200,"查询成功,传入值:"+ id,result);
    }
}
