package com.trackensure.onlinechat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.time.LocalDateTime;

public class Message {

    @JsonIgnore
    private Integer id;
    private String text;
    private String userName;
    @JsonIgnore
    private LocalDateTime date;

    public Message() {
    }

    public Message(String text, String userName) {
        this(null, text, userName, LocalDateTime.now());
    }

    public Message(String text, String userName, LocalDateTime date) {
        this(null, text, userName, date);
    }

    public Message(Integer id, String text, String userName, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.userName = userName;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                '}';
    }
}
