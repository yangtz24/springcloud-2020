package com.ytz.springcloud.service;

/**
 * @ClassName: IMessageProvider
 * @Description: TODO   消息生产者
 * @author: basketBoy
 * @date: 2020/6/20
 * @Version: V1.0
 */
public interface IMessageProvider {
    /**
     * 发送消息
     * @return
     */
    String send();
}
