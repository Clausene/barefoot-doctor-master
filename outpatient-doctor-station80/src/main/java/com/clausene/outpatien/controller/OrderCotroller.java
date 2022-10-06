package com.clausene.outpatien.controller;

import com.clausene.outpatien.entities.CommonResult;
import com.clausene.outpatien.entities.Payment;
import com.clausene.outpatien.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: Clausene
 * @Title: OrderCotroller
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 18:21
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderCotroller {

    // 集群服务提供者时，通过服务名称访问，必须设置restTemplate 的负载策略
    public static final String PAYMENT_URL = "http://OUTPATIENT-HALL";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyLB myLB;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id, CommonResult.class);
    }
    @GetMapping("/getServicesInfo")
    public CommonResult<Payment> getServicesInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getServicesInfo", CommonResult.class);
    }

    @GetMapping(value = "/getForEntity/{id}")
    public CommonResult getForEntity(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getServicesInfo", CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return new CommonResult(4444,"远程调用失败!");
        }
    }
    @GetMapping(value = "/getPort")
    public CommonResult getPort(){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getPort",CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return new CommonResult(4444,"远程调用失败!");
        }
    }
    @GetMapping(value = "/getPortForMyLB")
    public CommonResult getPortForMyLB(){

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("OUTPATIENT-HALL");
        ServiceInstance serviceInstance = myLB.getServiceInstance(serviceInstanceList);
        log.info("实例信息 ID:{},HOST:{},PORT:{},URI:{}",serviceInstance.getInstanceId(),serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        URI uri = serviceInstance.getUri();
        log.info("拼接后的uri:{}",uri+"/payment/getPort");
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(uri+"/payment/getPort",CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return new CommonResult(4444,"远程调用失败!");
        }
    }
}
