package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Mapper
public interface TbUserDao {
    /**
     * 判断是root用户个数，如果存在root用户返回true，如果没有，返回false
     *
     * @return boolean
     */
    public boolean haveRootUser();

    /**
     * 插入记录
     */
    public int insert(HashMap param);

    /**
     * 主要是获取新插入的记录的主键值，为什么不适用useGeneratedKeys,单节点mysql使用没问题
     */
    public Integer searchIdOpenId(String openId);

    /**
     * 找出用户所拥有的全部权限
     *
     * @param userId
     * @return
     */
    Set<String> searchUserPermissions(int userId);

    public Integer searchByOpenId(String openId);

    TbUser searchById(int userId);

    /**
     * 查询员工的姓名和部门名称
     */
    HashMap searchNameAndDept(int userId);

    /**
     * 查询员工的入职时间
     */
    public String searchUserHiredate(int userId);

    /**
     * 个人中心的查看，照片以及部门
     *
     * @param userId
     * @return
     */
    public HashMap searchUserSummary(int userId);

    public ArrayList<HashMap> searchUserGroupByDept(String keyword);

    public ArrayList<HashMap> searchMembers(List param);

    public HashMap searchUserInfo(int userId);

    public int searchDeptManagerId(int id);

    public int searchGmId();
}