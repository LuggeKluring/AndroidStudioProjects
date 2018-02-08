package com.example.williamanderssonber.carcompanion;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import java.util.List;

/**
 * Created by william.anderssonber on 2018-01-29.
 */
@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
public interface RefuelsDao {
    @Query("SELECT * FROM refuels")
    List<Refuels> getAll();


    @Insert
    public void insert(Refuels refuels);

    @Query("DELETE FROM refuels")
    public void deleteAll();

   /* void insertAll(Refuels... refuels);*/
    /*@Query("SELECT amount FROM refuels")
    List<Refuels> getRefuelData();*/
}
