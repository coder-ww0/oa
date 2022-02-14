package com.wei.emos.wx.db.dao;

import com.wei.emos.wx.db.pojo.TbMeeting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.crypto.hash.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface TbMeetingDao {

    public int insertMeeting(TbMeeting tbMeeting);

    public ArrayList<HashMap> searchMyMeetingListByPage(HashMap param);

    public boolean searchMeetingMembersInSameDept(String uuid);

    public int updateMeetingInstanceId(HashMap map);

    public HashMap searchMeetingById(int id);

    public ArrayList<HashMap> searchMeetingMembers(int id);

    public int updateMeetingInfo(HashMap param);

    public int deleteMeetingById(int id);

    public List<String> searchUserMeetingInMonth(HashMap param);
}