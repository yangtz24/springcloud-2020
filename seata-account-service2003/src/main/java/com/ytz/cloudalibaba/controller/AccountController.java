package com.ytz.cloudalibaba.controller;

import com.ytz.cloudalibaba.service.AccountService;
import com.ytz.cloudalibaba.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @ClassName: StorageController
 * @Description: TODO 账户业务Controller
 * @author: basketBoy
 * @date: 2020/6/22
 * @Version: V1.0
 */
@RestController
@RequestMapping("rest/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping(value = "decrease")
    public CommonResult<?> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功");
    }
}
