package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.TbCheckin;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface TbCheckinDao {
    public Integer haveCheckin(HashMap param);

    public void insert(TbCheckin entity);

    /**
     * 查询基本的用户信息，比如名字，部门，签到时间等
     * @param userId
     * @return
     */
    public HashMap searchTodayCheckin(int userId);

    /**
     * 签到的总次数
     */
    public long searchCheckinDays(int userId);

    /**
     * 查询对应的状态
     */
    public ArrayList<HashMap> searchWeekCheckin(HashMap param);
}