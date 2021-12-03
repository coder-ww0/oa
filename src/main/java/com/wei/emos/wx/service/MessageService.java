package com.wei.emos.wx.service;

import com.wei.emos.wx.db.pojo.MessageEntity;
import com.wei.emos.wx.db.pojo.MessageRefEntity;

import java.util.HashMap;
import java.util.List;

/**
 * @author www
 * @date 2021/11/30 13:47
 * @description: TODO
 */

public interface MessageService {

    public String insertMessage(MessageEntity entity);

    public String insertRef(MessageRefEntity entity);

    public long searchUnreadCount(int userId);

    public long searchLastCount(int userId);

    public List<HashMap> searchMessageByPage(int userId, long start, int length) ;

    public HashMap searchMessageById(String id);

    public long updateUnreadMessage(String id) ;

    public long deleteMessageRefById(String id);

    public long deleteUserMessageRef(int userId);
}
