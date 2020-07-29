package com.want.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 自己的配置不能放在 componentScan能扫描的包下，故要新建一个包
 *
 * 自行修改 负载均衡策略
 *
 *
 *
 * @author want
 * @createTime 2020.07.26.21:31
 */
@Configuration
public class MyRibbonRule {

    /**
     * 使用随机的 负载均衡策略
     * @return
     */
    @Bean
    public IRule myRule(){
        System.out.println("using random load balance client");
        return new RandomRule();
    }
}
