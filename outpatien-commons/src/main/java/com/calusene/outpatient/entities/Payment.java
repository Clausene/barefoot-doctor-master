package com.clausene.outpatien.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Clausene
 * @Title: Payment
 * @ProjectName: barefoot-doctor-master
 * @Description: 支付实体 实现Serializable 传输的时候会用到
 * @date: 2022/10/2 16:28
 */
@Data
public class Payment implements Serializable {
    private Long id;
    private String serialNumber;
}
