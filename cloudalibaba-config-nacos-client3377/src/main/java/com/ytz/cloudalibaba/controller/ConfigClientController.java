package com.ytz.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConfigClientController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@RestController
// 支持nacos的动态刷新
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}