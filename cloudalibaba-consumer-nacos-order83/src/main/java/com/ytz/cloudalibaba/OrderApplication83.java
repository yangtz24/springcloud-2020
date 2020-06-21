package com.ytz.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OrderApplication83
 * @Description: TODO  消费者
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication83.class, args);
    }
}
