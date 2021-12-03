package com.wei.emos.wx.service;

import com.wei.emos.wx.db.pojo.TbMeeting;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author www
 * @date 2021/12/1 11:48
 * @description: TODO
 */


public interface MeetingService {
    public void insertMeeting(TbMeeting entity);

    public ArrayList<HashMap> searchMyMeetingListByPage(HashMap param);

    public HashMap searchMeetingById(int id);

    public void updateMeetingInfo(HashMap param);

    public void deleteMeetingById(int id);
}
