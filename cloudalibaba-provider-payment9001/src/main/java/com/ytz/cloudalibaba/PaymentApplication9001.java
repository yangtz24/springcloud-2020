package com.ytz.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentApplication9001
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class, args);
    }
}
