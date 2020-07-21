package com.want.springcloud.dao;

import com.want.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author want
 * @createTime 2020.07.15.21:14
 */
@Mapper
public interface PaymentDAO {
    /**
     * 查询所有的 payment
     * @return
     */
    List<Payment> list();

    /**
     * 创建一个 payment
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id查找Payment
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
