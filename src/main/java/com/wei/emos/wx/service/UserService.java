package com.wei.emos.wx.service;

import com.wei.emos.wx.db.pojo.TbUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author www
 * @date 2021/11/25 10:18
 * @description: TODO
 */
public interface UserService {
    public int registerUser(String registerCode,String code,String nickname,String photo);

    public Set<String> searchUserPermissions(int userId);

    /**
     * 进行登录
     * @param code
     * @return
     */
    public Integer login(String code);

    /**
     * 根据id查找用户
     */
    public TbUser searchById(int userId);

    /**
     * 查询员工的入职时间
     */
    public String searchUserHiredate(int userId);

    /**
     * 查询员工的部门信息
     * @param userId
     * @return
     */
    public HashMap searchUserSummary(int userId);

    public ArrayList<HashMap> searchUserGroupByDept(String keyword);

    public ArrayList<HashMap> searchMembers(List param);
}
