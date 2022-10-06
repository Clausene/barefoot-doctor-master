package com.clausene.outpatien.service.imp;

import cn.hutool.core.util.IdUtil;
import com.clausene.outpatien.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: Clausene
 * @Title: PaymentHystrixServiceImpl
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 17:26
 */
@Service
// 这个类的统一降级处理方法，如果某个方法需要单独处理，则在具体的方法上配置 fallbackMethod
@DefaultProperties(defaultFallback = "getPaymentInfoTimeoutFallback")
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    /**
     * @author Clausene
     * @date 2022/10/4 19:26
     * @Description: 降级处理 @HystrixCommand，@HystrixProperty配置降级属性
     * @param:
     * @return java.lang.String
    */
    @HystrixCommand(commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String getPaymentInfoTimeout() {
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){

        }
        return "正常提供服务";
    }

    @HystrixCommand(fallbackMethod = "fallbackCircuit",// 降级返回方法
            commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),// 请求数量计数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//睡眠窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),// 异常占比
    })
    @Override
    public String getPaymentForCircuit(Long id) {
        if (id <0){
            throw new RuntimeException("传入值为负数");
        }
        String uuid = IdUtil.fastSimpleUUID();
        return Thread.currentThread().getName() + ":请求成功,流水号："+uuid;
    }
    public String fallbackCircuit(Long id) {
        return Thread.currentThread().getName()+"，传入值为负数："+id;
    }
    public String getPaymentInfoTimeoutFallback() {
        return "服务降级处理了";
    }
}
