package com.clausene.outpatien.service;


import com.clausene.outpatien.entities.Payment;

/**
 * @author: Clausene
 * @Title: PaymentService
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 17:04
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
