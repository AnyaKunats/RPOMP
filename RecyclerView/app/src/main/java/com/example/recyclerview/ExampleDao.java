package com.example.recyclerview;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ExampleDao {
    @Insert
    void insert(List<ExampleItem> item);

    @Query("SELECT * FROM table_")
    List<ExampleItem> getAllExampleItem();
}
