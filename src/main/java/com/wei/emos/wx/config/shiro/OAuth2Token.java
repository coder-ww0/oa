package com.wei.emos.wx.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author www
 * @date 2021/11/23 14:47
 * @description: 把令牌封装成认证对象
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
