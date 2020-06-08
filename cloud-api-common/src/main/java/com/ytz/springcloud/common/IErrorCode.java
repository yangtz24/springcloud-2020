
package com.ytz.springcloud.common;

/**
 * @ClassName: IErrorCode
 * @Description:  封装API的错误码
 * @author: yangtianzeng
 * @date: 2020/3/16 8:56
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}
