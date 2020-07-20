package com.want.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author want
 * @createTime 2020.07.20.20:16
 */
@SpringBootApplication
public class CloudConsumeOrder {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeOrder.class,args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
