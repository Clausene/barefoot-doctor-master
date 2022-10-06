package com.clausene.outpatien.service;

import com.clausene.outpatien.entities.CommonResult;
import com.clausene.outpatien.service.impl.OrderFeignHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Clausene
 * @Title: OderFeignService
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 10:05
 */
@Component
// 声明降级处理类，实现代码解耦
@FeignClient(value = "OUTPATIENT-HALL",fallback = OrderFeignHystrixServiceImpl.class)
public interface OrderFeignService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/getPaymentInfoOk")
    public CommonResult getPaymentInfoOk();

    @GetMapping(value = "/payment/getPaymentInfoTimeout")
    public CommonResult getPaymentInfoTimeout();
}
