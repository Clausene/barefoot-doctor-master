package com.clausene.outpatien.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.clausene.outpatien.entities.CommonResult;
import javax.annotation.Resource;

/**
 * @author: Clausene
 * @Title: OrderZkController
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/3 16:41
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderZkController {

    public final String request_URl= "http://outpatient-hall";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/getZkInfo")
    public CommonResult getZkInfo(){
        return restTemplate.getForObject(request_URl+"/payment/getZkInfo", CommonResult.class);
    }
}
