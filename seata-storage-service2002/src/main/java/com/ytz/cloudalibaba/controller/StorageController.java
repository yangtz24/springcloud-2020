package com.ytz.cloudalibaba.controller;

import com.ytz.cloudalibaba.service.StorageService;
import com.ytz.cloudalibaba.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: StorageController
 * @Description: TODO  库存业务Controller
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "decrease")
    public CommonResult<?> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "扣减库存成功");
    }
}
