package com.want.springcloud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author want
 * @createTime 2020.07.15.21:02
 */
@SpringBootApplication
public class CloudProviderPayment{
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment.class,args);
    }

}
