package com.trackensure.onlinechat.endpoints;

import com.trackensure.onlinechat.coders.MessageDecoder;
import com.trackensure.onlinechat.coders.MessageEncoder;
import com.trackensure.onlinechat.dao.MessageDaoImpl;
import com.trackensure.onlinechat.model.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint(value = "/onlinechat",
        encoders = MessageEncoder.class,
        decoders = MessageDecoder.class)
public class EndpointChat {

    private Session session = null;
    private static List<Session> sessionList = new ArrayList<>();
    private MessageDaoImpl messageDao = new MessageDaoImpl();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sessionList.add(session);
        List<Message> lastsMessages = messageDao.getLasts();
        lastsMessages.forEach(m-> {
            try {
                session.getBasicRemote().sendObject(m);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    @OnClose
    public void onClose(Session session) {
        sessionList.remove(session);
    }

    @OnMessage
    public void OnMessage(Session session, Message msg) {
        for (Session s : sessionList) {
            s.getAsyncRemote().sendObject(msg);
        }
        messageDao.save(msg);
    }

    @OnError
    public void OnError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
