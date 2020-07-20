package com.want.springcloud.api;


import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
import com.want.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author want
 * @createTime 2020.07.15.21:28
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentApi {
    @Resource
    PaymentService paymentService;

    @GetMapping("/list")
    public CommonResult<List<Payment>> list(){
        log.info("list api ");
        return new CommonResult(paymentService.list());
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return new CommonResult<>(paymentService.getPaymentById(id));
    }

    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment){
        return new CommonResult<>(paymentService.create(payment) > 0);
    }
}
