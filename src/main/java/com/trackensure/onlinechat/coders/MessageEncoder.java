package com.trackensure.onlinechat.coders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trackensure.onlinechat.model.Message;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import static com.trackensure.onlinechat.util.JsonUtil.getMapper;

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public String encode(Message message) {
        String encodedMessage = "";
        try {
            encodedMessage = getMapper().writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return encodedMessage;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
