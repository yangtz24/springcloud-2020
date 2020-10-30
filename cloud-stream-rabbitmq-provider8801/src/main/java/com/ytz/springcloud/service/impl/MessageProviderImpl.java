package com.ytz.springcloud.service.impl;

import com.ytz.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName: MessageProviderImpl
 * @Description: TODO 定义消息的推送管道
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().replace("-", "");
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial = " + serial);
        return serial;
    }
}
