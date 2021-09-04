package com.trackensure.onlinechat.dao;

import com.trackensure.onlinechat.PostgresConnect;
import com.trackensure.onlinechat.model.Message;

import java.sql.*;
import java.util.List;

import static com.trackensure.onlinechat.util.MessageUtil.createList;

public class MessageDaoImpl implements MessageDao {

    private static final String SELECT_WITH_LIMIT = "SELECT * FROM messages ORDER BY date_time ASC LIMIT 50";
    private static final String INSERT_MESSAGE = "INSERT INTO messages (text, user_name) values (?, ?)";
    private PostgresConnect pConnect = new PostgresConnect();

    @Override
    public List<Message> getLasts() {
        List<Message> list = null;
        try {
            Connection connect = pConnect.getConnect();
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_WITH_LIMIT);
            list = createList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pConnect.disconnect();
        }
        return list;
    }

    @Override
    public void save(Message message) {
        try {
            PreparedStatement ps = pConnect.getConnect().prepareStatement(INSERT_MESSAGE);
            ps.setString(1, message.getText());
            ps.setString(2, message.getUserName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pConnect.disconnect();
        }
    }
}
