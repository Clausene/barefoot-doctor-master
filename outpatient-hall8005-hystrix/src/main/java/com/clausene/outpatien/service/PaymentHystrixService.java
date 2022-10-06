package com.clausene.outpatien.service;

/**
 * @author: Clausene
 * @Title: PaymentHystrixService
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/4 17:24
 */
public interface PaymentHystrixService {

    public String getPaymentInfoTimeout();

    public String getPaymentForCircuit(Long id);
}
