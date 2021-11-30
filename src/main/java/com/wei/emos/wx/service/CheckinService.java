package com.wei.emos.wx.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author www
 * @date 2021/11/27 13:04
 * @description: TODO
 */
public interface CheckinService {
    /**
     * 判断是否可以进行签到
     *
     * @param userId
     * @param date
     * @return
     */
    public String validCanCheckIn(int userId, String date);

    /**
     * 进行签到
     */
    void checkin(HashMap param);

    /**
     * 生成人脸模型，利用python生成对应的人脸模型，保存到数据库中
     */
    void createFaceModel(int userId, String path);

    public HashMap searchTodayCheckin(int userId);

    public long searchCheckinDays(int userId);

    public ArrayList<HashMap> searchWeekCheckin(HashMap param);

    /**
     * 查询某个月内的签到情况
     * @param param
     * @return
     */
    public ArrayList<HashMap> searchMonthCheckin(HashMap param);
}
