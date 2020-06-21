package com.ytz.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ytz.springcloud.common.CommonResult;

/**
 * @ClassName: CustomerBlockHandler
 * @Description: TODO  自定义处理
 * @author: basketBoy
 * @date: 2020/6/21
 * @Version: V1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "客户自定义---1，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "客户自定义---2，global handlerException---2");
    }
}

