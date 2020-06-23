package com.ytz.cloudalibaba.controller;

import com.ytz.cloudalibaba.domain.Order;
import com.ytz.cloudalibaba.service.OrderService;
import com.ytz.cloudalibaba.util.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @PostMapping("create")
    public CommonResult<?> create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }

}
