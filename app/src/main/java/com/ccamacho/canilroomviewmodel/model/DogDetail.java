package com.ccamacho.canilroomviewmodel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogDetail {

    private String id;
    private String url;
    private int width;
    private int height;

    @SerializedName("breeds")
    private List<Dog> dogList;

    public DogDetail(String id, String url, int width, int height, List<Dog> dogList) {
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
        this.dogList = dogList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }
}
