package com.ytz.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: NacosConfigClientApplication3377
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication3377.class, args);
    }
}
