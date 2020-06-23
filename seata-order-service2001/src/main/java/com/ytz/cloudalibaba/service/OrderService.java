package com.ytz.cloudalibaba.service;

import com.ytz.cloudalibaba.domain.Order;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
