package com.example.williamanderssonber.carcompanion;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by william.anderssonber on 2018-01-29.
 */
@Dao
public interface RefuelsDao {
    @Query("SELECT * FROM refuels")
    List<Refuels> getAll();

    @Query("SELECT amount FROM refuels")
    List<Refuels> loadRefuelData();
}
