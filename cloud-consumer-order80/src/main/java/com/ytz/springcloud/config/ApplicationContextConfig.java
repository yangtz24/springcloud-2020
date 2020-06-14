package com.ytz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Description: 负载均衡 配置
 *   负载均衡算法：rest接口第几次请求数 % 服务集群总数量 = 实际调用服务器位置下标，每次服务重启后，rest接口技术从1开始
 * @author: yangtianzeng
 * @date: 2020/3/19 9:14
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
