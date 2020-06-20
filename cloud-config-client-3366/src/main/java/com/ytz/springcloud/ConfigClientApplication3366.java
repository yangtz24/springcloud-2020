package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: ConfigClientApplication3366
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/19
 * @Version: V1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3366.class, args);
    }
}
