package com.ytz.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: OrderNacosApplication84
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosApplication84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication84.class, args);
    }
}
