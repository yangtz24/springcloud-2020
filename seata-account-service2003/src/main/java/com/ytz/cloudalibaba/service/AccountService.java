package com.ytz.cloudalibaba.service;

import java.math.BigDecimal;

/**
 * @ClassName: OrderService
 * @Description: TODO  账户业务
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
public interface AccountService {

    /**
     * 减账户金额
     *
     * @param userId
     * @param money
     * @return
     */
    int decrease(Long userId, BigDecimal money);
}
