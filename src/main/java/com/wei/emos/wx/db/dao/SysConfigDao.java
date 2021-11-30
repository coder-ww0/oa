package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.SysConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysConfigDao {
    /**
     * 查找考勤相关信息
     */
    public List<SysConfig> selectAllParam();
}