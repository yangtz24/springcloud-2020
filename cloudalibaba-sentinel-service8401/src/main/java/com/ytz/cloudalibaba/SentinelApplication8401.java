package com.ytz.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: SentinelApplication8401
 * @Description: TODO Sentinel
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class SentinelApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication8401.class, args);
    }
}
