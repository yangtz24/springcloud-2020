package com.ytz.cloudalibaba.service.feign;

import com.ytz.cloudalibaba.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @ClassName: AccountService
 * @Description: TODO
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@FeignClient("seata-account-service")
public interface AccountService {

    /**
     * 减余额
     *
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "rest/account/decrease")
    CommonResult<?> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
