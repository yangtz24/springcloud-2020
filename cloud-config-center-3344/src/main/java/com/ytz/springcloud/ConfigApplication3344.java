package com.ytz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName: ConfigApplication3344
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/19
 * @Version: V1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class, args);
    }
}
