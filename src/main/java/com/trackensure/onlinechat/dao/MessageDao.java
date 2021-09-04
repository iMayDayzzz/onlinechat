package com.trackensure.onlinechat.dao;

import com.trackensure.onlinechat.model.Message;

import java.util.List;

public interface MessageDao {

    List<Message> getLasts();

    void save(Message message);

}
