/**
 * Copyright © 2019 国网信通产业集团. All rights reserved.
 *
 * @Title:PaymentServiceImpl.java
 * @Prject: com.ytz.springcloud.service.impl
 * @Package: com.ytz.springcloud.service.impl
 * @author: yangtianzeng
 * @date: 2020/3/18 13:44
 * @version: V1.0
 */
package com.ytz.springcloud.service.impl;

import com.ytz.springcloud.dao.PaymentMapper;
import com.ytz.springcloud.entities.Payment;
import com.ytz.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: PaymentServiceImpl
 * @Description: 支付service实现类
 * @author: yangtianzeng
 * @date: 2020/3/18 13:44
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);

    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
