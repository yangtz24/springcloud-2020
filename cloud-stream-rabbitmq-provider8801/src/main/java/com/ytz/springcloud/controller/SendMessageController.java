package com.ytz.springcloud.controller;

import com.ytz.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: SendMessageController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
