package com.want.springcloud.api;

import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author want
 * @createTime 2020.07.29.22:34
 */
@FeignClient("CLOUD-PROVIDER-PAYMENT")
public interface FeignClientApi {

    @GetMapping("/payment/list")
    CommonResult<List<Payment>> list();

    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


}
