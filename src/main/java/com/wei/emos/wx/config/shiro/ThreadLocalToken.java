package com.wei.emos.wx.config.shiro;

import org.springframework.stereotype.Component;

/**
 * @author www
 * @date 2021/11/23 15:44
 * @description: TODO
 */

@Component
public class ThreadLocalToken {
    private ThreadLocal<String> local = new ThreadLocal<>();

    public void setToken(String token) {
        local.set(token);
    }

    public String getToken() {
        return (String) local.get();
    }

    public void clear() {
        local.remove();
    }
}
