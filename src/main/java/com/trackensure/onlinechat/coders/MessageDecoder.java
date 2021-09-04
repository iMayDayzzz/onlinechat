package com.trackensure.onlinechat.coders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trackensure.onlinechat.model.Message;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import static com.trackensure.onlinechat.util.JsonUtil.getMapper;

public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public Message decode(String s) {
        Message message = null;
        try {
            message = getMapper().readValue(s, Message.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
