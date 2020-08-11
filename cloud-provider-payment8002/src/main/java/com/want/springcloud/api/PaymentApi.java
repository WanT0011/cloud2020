package com.want.springcloud.api;


import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.want.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    @Value("${server.port}")
    private String serverPort;
    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public CommonResult<List<Payment>> list(){
        log.info("list api ");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(paymentService.list(),serverPort);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return new CommonResult<>(paymentService.getPaymentById(id),serverPort);
    }

    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment){
        return new CommonResult<>(paymentService.create(payment) > 0,serverPort);
    }
    @GetMapping("listAllService")
    public CommonResult<List<String>> listAllService(){
        return new CommonResult<>(discoveryClient.getServices(),serverPort);
    }
    @GetMapping("listPaymentService")
    public CommonResult<List<String>> listPaymentService(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        List<String> list = instances.stream().map(ServiceInstance::getServiceId).collect(Collectors.toList());
        return new CommonResult<>(list,serverPort);
    }
}
