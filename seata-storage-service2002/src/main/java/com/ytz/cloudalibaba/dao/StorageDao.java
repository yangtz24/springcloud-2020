package com.ytz.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: OrderDao
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@Mapper
public interface StorageDao {

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
