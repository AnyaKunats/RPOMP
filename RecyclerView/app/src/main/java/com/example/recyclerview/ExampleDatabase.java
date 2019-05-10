package com.example.recyclerview;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ExampleItem.class}, version = 1)
public abstract class ExampleDatabase extends RoomDatabase {
    private static ExampleDatabase instance;

    public abstract ExampleDao dao();

    public static synchronized ExampleDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ExampleDatabase.class, "database_").build();
        }
        return instance;
    }
}
