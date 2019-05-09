package com.example.recyclerview;

public class ExampleItem {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;
    private int mFavorites;
    private int mComments;

    public ExampleItem(String imageUrl, String creator, int likes, int favorites, int comments) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
        mFavorites = favorites;
        mComments = comments;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }

    public int getmFavorites() {
        return mFavorites;
    }

    public int getmComments() {
        return mComments;
    }
}
