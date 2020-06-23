package com.ytz.cloudalibaba.service.impl;

import com.ytz.cloudalibaba.dao.AccountDao;
import com.ytz.cloudalibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO 账户业务处理类
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@Service
@Slf4j
public class AccountServiceImpl  implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public int decrease(Long userId, BigDecimal money) {
        log.info("*******->account-service中扣减账户余额开始");
        // 模拟超时异常,全局事务回滚
        // try { TimeUnit.SECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
        int result = accountDao.decrease(userId, money);
        if (result <= 0) {
            throw new RuntimeException("扣减账户余额错误！！！");
        }
        log.info("*******->account-service中扣减账户余额结束");
        return result;
    }
}
