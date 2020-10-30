package com.ytz.springcloud.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName: HystrixRequestContextFilter
 * @Description: TODO 处理请求错误
 * java.lang.IllegalStateException: Request caching is not available. Maybe you need to initialize the HystrixRequestContext?
 * @author: basketBoy
 * @date: 2020/6/16
 * @Version: V1.0
 */
@Component
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class HystrixRequestContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            hystrixRequestContext.close();
        }
    }
}
