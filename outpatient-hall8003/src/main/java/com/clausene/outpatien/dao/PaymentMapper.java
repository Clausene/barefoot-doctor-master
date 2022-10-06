package com.clausene.outpatien.dao;

import com.clausene.outpatien.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Clausene
 * @Title: Payment
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 16:49
 */
@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
