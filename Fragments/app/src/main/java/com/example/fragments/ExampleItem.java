package com.example.fragments;

public class ExampleItem {

    private int id;
    private String imageUrl;
    private String creator;
    private int likes;
    private int favorites;
    private int comments;


    public ExampleItem(String imageUrl, String creator, int likes, int favorites, int comments) {
        this.imageUrl = imageUrl;
        this.creator = creator;
        this.likes = likes;
        this.favorites = favorites;
        this.comments = comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCreator() {
        return creator;
    }

    public int getLikes() {
        return likes;
    }

    public int getFavorites() {
        return favorites;
    }

    public int getComments() {
        return comments;
    }


}
