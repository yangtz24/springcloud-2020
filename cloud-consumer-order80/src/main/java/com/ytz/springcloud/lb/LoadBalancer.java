package com.ytz.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName: LoadBalancer
 * @Description: TODO 自定义负载均衡
 * @author: basketBoy
 * @date: 2020/6/13
 * @Version: V1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
