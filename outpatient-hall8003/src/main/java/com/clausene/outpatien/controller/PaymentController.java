package com.clausene.outpatien.controller;

import com.clausene.outpatien.entities.CommonResult;
import com.clausene.outpatien.entities.Payment;
import com.clausene.outpatien.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Clausene
 * @Title: PaymentController
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 17:08
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create",produces = "application/json",name = "")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入数据成功,端口:"+port,result);
        }else{
            return new CommonResult(500,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：{}",payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,端口:"+ port,payment);
        }else{
            return new CommonResult(500,"没有对应记录,查询Id："+id,null);
        }
    }
    @GetMapping(value = "/getServicesInfo")
    public CommonResult getServicesInfo(){
        List<String> serviceList = discoveryClient.getServices();
        for (String service: serviceList) {
            log.info("已经完成注册的服务：{}",service);
        }
        // 获取这个实例名的服务信息
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("OUTPATIENT-HALL");
        for (ServiceInstance serviceInstance  :serviceInstanceList) {
            log.info("实例信息 ID:{},HOST:{},PORT:{},URI:{}",serviceInstance.getInstanceId(),serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        }
        return new CommonResult(200,"查询成功,端口:"+ port,serviceInstanceList);
    }
    @GetMapping(value = "/getPort")
    public CommonResult getPort(){
        return new CommonResult(200,port);
    }
}
