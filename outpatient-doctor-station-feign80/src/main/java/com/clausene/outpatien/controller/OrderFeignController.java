package com.clausene.outpatien.controller;

import com.clausene.outpatien.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clausene.outpatien.entities.CommonResult;

import javax.annotation.Resource;

/**
 * @author: Clausene
 * @Title: OrderFeignController
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 10:02
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return  orderFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/getPaymentInfoOk")
    public CommonResult getPaymentInfoOk(){
        return orderFeignService.getPaymentInfoOk();
    }

    @GetMapping(value = "/getPaymentInfoTimeout")
    public CommonResult getPaymentInfoTimeout(){
        return orderFeignService.getPaymentInfoTimeout();
    }
}
