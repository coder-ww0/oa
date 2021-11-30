package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.TbWorkday;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface TbWorkdayDao {
    public Integer searchTodayIsWorkday();

    /**
     * 查找对应的时间内是否是工作日
     */
    public ArrayList<String> searchWorkdayInRange(HashMap param);
}