package com.want.springcloud.service;

import com.want.springcloud.entitys.Payment;

import java.util.List;

/**
 * @author want
 * @createTime 2020.07.15.21:21
 */
public interface PaymentService {
    /**
     * 查找所有的
     * @return
     */
    List<Payment> list();

    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
