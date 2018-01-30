package com.example.williamanderssonber.carcompanion;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by william.anderssonber on 2018-01-29.
 */

@Database(entities = {Refuels.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract RefuelsDao refuelsDao();
    public static AppDatabase getAppDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "refuels-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}

