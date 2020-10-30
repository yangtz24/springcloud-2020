package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OrderApplicationZk
 * @Description: 启动类
 * @author: yangtianzeng
 * @date: 2020/3/19 18:24
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class OrderApplicationZk {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationZk.class, args);
    }
}
