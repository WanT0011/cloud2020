package com.want.springcloud.api;


import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
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
@RequestMapping("/consumer")
public class ConsumerApi {
    private static final String PREFIX = "http://127.0.0.1:8001";
    private static final String SP = "/";
    private static final String API_PATH = "payment";

    private String consumerTestPrefix = PREFIX + SP + API_PATH + SP;
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
}
