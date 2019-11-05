package com.example.android3.data.entity;

public class OnBoardEntity {

    private String  title;
    private int img;

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public OnBoardEntity(String title, int img) {
        this.title = title;
        this.img = img;
    }
}
