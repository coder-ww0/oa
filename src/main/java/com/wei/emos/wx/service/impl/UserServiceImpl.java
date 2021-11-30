package com.wei.emos.wx.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.wei.emos.wx.db.dao.TbUserDao;
import com.wei.emos.wx.db.pojo.TbUser;
import com.wei.emos.wx.exception.EmosException;
import com.wei.emos.wx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.PushbackReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * @author www
 * @date 2021/11/25 10:18
 * @description: TODO
 */
@Service
@Slf4j
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Value("${wx.app-id}")
    private String appId;

    @Value("${wx.app-secret}")
    private String appSecret;

    @Autowired
    private TbUserDao userDao;

    private String getOpenId(String code) {
        // 根据微信传来的code，返回openid
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HashMap map = new HashMap();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String response = HttpUtil.post(url, map);
        JSONObject json = JSONUtil.parseObj(response);
        String openId = json.getStr("openid");
        if (openId == null || openId.length() == 0) {
            throw new RuntimeException("临时登录凭证错误");
        }
        return openId;
    }

    @Override
    public int registerUser(String registerCode, String code, String nickname, String photo) {
        // 如果邀请码是000000，代表是超级管理员
        if (registerCode.equals("000000")) {
            // 查询数据库中是否存在超级管理员(超级管理员只能有一个)
            boolean bool = userDao.haveRootUser();
            if (!bool) {
                // 把当前用户绑定到ROOT账户
                String openId = getOpenId(code);
                HashMap param = new HashMap();
                param.put("openId", openId);
                param.put("nickname", nickname);
                param.put("photo", photo);
                param.put("role", "[0]");
                param.put("status", 1);
                param.put("createTime", new Date());
                param.put("root", true);
                userDao.insert(param);
                int id = userDao.searchIdOpenId(openId);
                return id;
            } else{
                // 如果root已经绑定了，就抛出异常
                throw new EmosException("无法绑定超级管理员");
            }
        } else {
            return 0;
        }
    }

    @Override
    public Set<String> searchUserPermissions(int userId) {
        Set<String> permissions = userDao.searchUserPermissions(userId);
        return permissions;
    }

    /**
     * 进行登录
     *
     * @param code
     * @return
     */
    @Override
    public Integer login(String code) {
        String openId = getOpenId(code);
        Integer id = userDao.searchIdOpenId(openId);
        if (id == null) {
            throw new EmosException("账户不存在");
        }
        // TODO 从消息队列中接受消息，转移到消息表
        return id;
    }

    /**
     * 根据id查找用户
     *
     * @param userId
     */
    @Override
    public TbUser searchById(int userId) {
        TbUser user = userDao.searchById(userId);
        return user;
    }

    /**
     * 查询员工的入职时间
     *
     * @param userId
     */
    @Override
    public String searchUserHiredate(int userId) {
        String hiredate = userDao.searchUserHiredate(userId);
        return hiredate;
    }

    /**
     * 查询员工的部门信息
     *
     * @param userId
     * @return
     */
    @Override
    public HashMap searchUserSummary(int userId) {
        HashMap map = userDao.searchUserSummary(userId);
        return map;
    }
}
