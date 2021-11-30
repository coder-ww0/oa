package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.TbCity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbCityDao {
    /**
     * 根据城市名称查找城市code，比如  荆州市 --->> jingzhou
     * @param city
     * @return
     */
    String searchCode(String city);
}