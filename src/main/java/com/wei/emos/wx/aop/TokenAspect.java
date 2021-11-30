package com.wei.emos.wx.aop;

import com.wei.emos.wx.common.util.R;
import com.wei.emos.wx.config.shiro.ThreadLocalToken;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author www
 * @date 2021/11/23 20:51
 * @description: TODO
 */

@Aspect
@Component
public class TokenAspect {
    @Autowired
    private ThreadLocalToken threadLocalToken;

    @Pointcut("execution(public * com.wei.emos.wx.controller.*.*(..))")
    public void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 方法执行结果
        R r = (R) point.proceed();
        String token = threadLocalToken.getToken();
        // 如果ThreadLocal中存在token，说明是更新的token
        if (token != null) {
            // 往响应中放置token
            r.put("token", token);
            // 如果不清空，下次请求进来，还是这个线程进来，发现threadlocal存在令牌，就把这个令牌发给另一个手机用户
            threadLocalToken.clear();
        }
        return r;
    }

}
