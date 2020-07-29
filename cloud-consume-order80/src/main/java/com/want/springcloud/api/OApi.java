package com.want.springcloud.api;

import com.want.springcloud.entitys.CommonResult;
import com.want.springcloud.entitys.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author want
 * @createTime 2020.07.29.23:06
 */
//注意，这个 “feign” 不生效！！！！
@RestController("feign")
public class OApi {
    @Resource
    FeignClientApi feignClientApi;


    @GetMapping("/list")
    CommonResult<List<Payment>> list(){
        System.out.println("list>..");
        return feignClientApi.list();
    }
}
