package com.ytz.cloudalibaba.service.impl;

import com.ytz.cloudalibaba.dao.StorageDao;
import com.ytz.cloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO 库存业务处理类
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @Override
    public int decrease(Long productId, Integer count) {
        int result = storageDao.decrease(productId, count);
        if (result <= 0) {
            throw new RuntimeException("减库存失败");
        }
        return result;
    }
}
