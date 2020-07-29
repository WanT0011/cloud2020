package com.want.springcloud.config;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author want
 * @createTime 2020.07.26.22:25
 */
public class MyLoadBalance  {

    private AtomicInteger count = new AtomicInteger(0);

    /**
     * 轮询获取实例对象进行服务
     * @param serviceInstances
     * @return
     */
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances){
        final int serviceSize = serviceInstances.size();
        if(serviceSize == 0){
            throw new RuntimeException("error , have no server instance!");
        }
        int value = 0;
        int next = 0;
        do{
            value = count.get();
            next = value == Integer.MAX_VALUE ? 0 : value + 1;
        }while (count.compareAndSet(value,next));

        final int index = next % serviceSize;
        return serviceInstances.get(index);
    }

}
