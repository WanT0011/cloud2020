package com.want.springcloud.api;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author want
 * @createTime 2020.07.20.20:20
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerApi {
    private static final String PREFIX = "http://127.0.0.1:8001";
    private static final String SP = "/";
    private static final String API_PATH = "payment";

//    private String consumerTestPrefix = PREFIX + SP + API_PATH + SP;
    private String consumerTestPrefix = "http://CLOUD-PROVIDER-PAYMENT" + SP + API_PATH + SP;
    
    private static final String SERVICE_ID = "CLOUD-PROVIDER-PAYMENT";
    
    @Resource
    RestTemplate restTemplate;

    

    
    
    @GetMapping("/list")
    public CommonResult<List<Payment>> list(){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(consumerTestPrefix + "list", CommonResult.class);
        if(entity != null){
            return entity.getBody();
        }
        return null;
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(consumerTestPrefix + id, CommonResult.class);
        if(entity != null){
            return entity.getBody();
        }
        return null;
    }

    @PostMapping("/create")
    public CommonResult<Boolean> create(HttpServletRequest request){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(consumerTestPrefix + "create",request, CommonResult.class);
        if(entity != null){
            return entity.getBody();
        }
        return null;
    }

    @GetMapping("listAllService")
    public CommonResult<List<String>> listAllService(){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(consumerTestPrefix + "listAllService", CommonResult.class);
        if(entity != null){
            return entity.getBody();
        }
        return null;
    }
    @GetMapping("listPaymentService")
    public CommonResult<List<String>> listPaymentService(){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(consumerTestPrefix + "listPaymentService", CommonResult.class);
        if(entity != null){
            return entity.getBody();
        }
        return null;
    }
    
    
}
