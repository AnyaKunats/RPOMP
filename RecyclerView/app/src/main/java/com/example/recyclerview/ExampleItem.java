package com.example.recyclerview;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "table_")

public class ExampleItem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "image")
    private String imageUrl;
    @ColumnInfo(name = "creator")
    private String creator;
    @ColumnInfo(name = "likes")
    private int likes;
    @ColumnInfo(name = "favorites")
    private int favorites;
    @ColumnInfo(name = "comments")
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
