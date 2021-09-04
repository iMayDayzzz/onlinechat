package com.trackensure.onlinechat.util;

import com.trackensure.onlinechat.model.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageUtil {

    public static List<Message> createList(ResultSet rs) throws SQLException {
        Objects.requireNonNull(rs);
        List<Message> messageList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String text = rs.getString("text");
            String userName = rs.getString("user_name");
            LocalDateTime localDateTime = rs.getObject("date_time", LocalDateTime.class);
            Message msg = new Message(id, text, userName, localDateTime);
            messageList.add(msg);
        }
        return messageList;
    }
}
