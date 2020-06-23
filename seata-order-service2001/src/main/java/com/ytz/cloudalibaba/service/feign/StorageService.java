package com.ytz.cloudalibaba.service.feign;

import com.ytz.cloudalibaba.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: StorageService
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "rest/storage/decrease")
    CommonResult<?> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
