package com.example.mypetapp;

import java.io.Serializable;

public class Dogs implements Serializable {

    private String name;
    private int likes;
    private int photoID;

    public Dogs(String name, int likes, int photoID) {
        this.name = name;
        this.likes = likes;
        this.photoID = photoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
}
