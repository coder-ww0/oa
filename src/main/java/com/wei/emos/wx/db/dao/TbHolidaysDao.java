package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.TbHolidays;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface TbHolidaysDao {
    public Integer searchTodayIsHolidays();

    /**
     * 查找对应的时间间隔内是否是节假日
     */
    public ArrayList<String> searchHolidaysInRange(HashMap param);
}