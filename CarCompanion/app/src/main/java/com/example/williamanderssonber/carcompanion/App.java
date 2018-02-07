package com.example.williamanderssonber.carcompanion;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by william.anderssonber on 2018-02-01.
 */

public class App extends Application {
    public static App INSTANCE;
    private static final String DATABASE_NAME = "MyDatabase";


    private AppDatabase database;

    public static App get() {
        return INSTANCE;
    }


    public void onCreate(Context context) {
        Log.d("app", "onCreate: ");
        super.onCreate();

        // create database
        database = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();

        INSTANCE = this;
    }

    public AppDatabase getDB() {
        return database;
    }

}
