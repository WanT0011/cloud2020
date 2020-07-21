package com.want.springcloud.service.impl;


import com.want.springcloud.entitys.Payment;
import org.springframework.stereotype.Service;
import com.want.springcloud.dao.PaymentDAO;
import com.want.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author want
 * @createTime 2020.07.15.21:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDAO paymentDAO;
    /**
     * 查找所有的
     *
     * @return
     */
    @Override
    public List<Payment> list() {
        return paymentDAO.list();
    }

    /**
     * 创建
     *
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
