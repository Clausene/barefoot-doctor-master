package com.clausene.outpatien.service.imp;

import com.clausene.outpatien.dao.PaymentMapper;
import com.clausene.outpatien.entities.Payment;
import com.clausene.outpatien.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Clausene
 * @Title: PaymentServiceImpl
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 17:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
