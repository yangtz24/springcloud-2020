package com.ytz.cloudalibaba.dao;

import com.ytz.cloudalibaba.domain.Order;
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
public interface OrderDao {

    /**
     * 1 新建订单
     *
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2 修改订单状态,从0改为1
     *
     * @param userId
     * @param status
     * @return
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);

}
