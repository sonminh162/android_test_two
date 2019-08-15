package com.lifetime.myapplication.model;

public class Message {
    private int avatar;
    private String name;
    private String messageContent;
    private String time;

    private String countMessage;
    private boolean online;
    private boolean newMessage;

    public Message(int avatar, String name, String messageContent, String time) {
        this.avatar = avatar;
        this.name = name;
        this.messageContent = messageContent;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isNewMessage() {
        return newMessage;
    }

    public void setNewMessage(boolean newMessage) {
        this.newMessage = newMessage;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getCountMessage() {
        return countMessage;
    }

    public void setCountMessage(String countMessage) {
        this.countMessage = countMessage;
    }
}
