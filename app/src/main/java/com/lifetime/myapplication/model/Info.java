package com.lifetime.myapplication.model;

public class Info {
    private int avatar;
    private String name;
    private String time;
    private String content;
    private int background;
    private String price;

    public Info(int avatar, String name, String time, String content, int background, String price) {
        this.avatar = avatar;
        this.name = name;
        this.time = time;
        this.content = content;
        this.background = background;
        this.price = price;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
