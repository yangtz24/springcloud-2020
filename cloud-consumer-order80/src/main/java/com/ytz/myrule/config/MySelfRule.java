package com.ytz.myrule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MySelfRule
 * @Description: TODO 自定义负载均衡路由规则类
 * @author: basketBoy
 * @date: 2020/6/13
 * @Version: V1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myrule() {
        return new RandomRule();
    }
}
