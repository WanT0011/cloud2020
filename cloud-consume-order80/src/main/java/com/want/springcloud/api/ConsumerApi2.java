package com.want.springcloud.api;


import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author want
 * @createTime 2020.07.20.20:20
 */
@RestController
@RequestMapping("/consumer2")
public class ConsumerApi2 {
    @Autowired
    FeignClientApi feignClientApi;

    @GetMapping("/list")
    public CommonResult<List<Payment>> list() throws InterruptedException {
        return feignClientApi.list();
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return feignClientApi.getPaymentById(id);
    }
}
