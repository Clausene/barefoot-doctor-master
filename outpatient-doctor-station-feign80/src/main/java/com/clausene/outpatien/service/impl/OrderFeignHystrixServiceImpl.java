package com.clausene.outpatien.service.impl;

import com.clausene.outpatien.entities.CommonResult;
import com.clausene.outpatien.service.OrderFeignService;
import org.springframework.stereotype.Component;

/**
 * @author: Clausene
 * @Title: OrderFeignHystrixServiceImpl
 * @ProjectName: barefoot-doctor-master
 * @Description: 客户端降级处理类，对应调用的没有个接口
 * @date: 2022/10/4 18:40
 */
@Component
public class OrderFeignHystrixServiceImpl implements OrderFeignService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(500,"根据id 获取失败");
    }

    @Override
    public CommonResult getPaymentInfoOk() {
        return new CommonResult(500,"请求getPaymentInfoOk接口异常");
    }

    @Override
    public CommonResult getPaymentInfoTimeout() {
        return new CommonResult(500,"请求getPaymentInfoTimeout接口异常");
    }
}
