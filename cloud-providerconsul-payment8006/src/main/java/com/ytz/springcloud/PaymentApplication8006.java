package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentApplication8006
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/12
 * @Version: V1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class PaymentApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8006.class, args);
    }
}
