package com.ytz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Description: 负载均衡 配置
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
