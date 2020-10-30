/**
 * Copyright © 2019 国网信通产业集团. All rights reserved.
 *
 * @Title:PaymentService.java
 * @Prject: com.ytz.springcloud.service
 * @Package: com.ytz.springcloud.service
 * @author: yangtianzeng
 * @date: 2020/3/18 13:43
 * @version: V1.0
 */
package com.ytz.springcloud.service;


import com.ytz.springcloud.entities.Payment;

/**
 * @ClassName: PaymentService
 * @Description: 支付service
 * @author: yangtianzeng
 * @date: 2020/3/18 13:43
 */
public interface PaymentService {
    /**
     * 创建一个支付信息
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
