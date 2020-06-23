package com.ytz.cloudalibaba.service;

/**
 * @ClassName: OrderService
 * @Description: TODO  库存业务
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
public interface StorageService {

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    int decrease(Long productId, Integer count);
}
