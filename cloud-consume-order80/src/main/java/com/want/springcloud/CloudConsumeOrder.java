package com.want.springcloud;

import com.want.ribbon.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author want
 * @createTime 2020.07.20.20:16
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = MyRibbonRule.class)
@EnableFeignClients
public class CloudConsumeOrder {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeOrder.class,args);
    }

    @Bean
    /**
     * 使用自己的负载均衡，去除ribbon自带的注解
     */
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
