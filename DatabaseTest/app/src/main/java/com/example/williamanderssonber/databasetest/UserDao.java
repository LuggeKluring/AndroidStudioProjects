package com.example.williamanderssonber.databasetest;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by william.anderssonber on 2018-01-30.
 */

public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE first_name LIKE :firstName AND last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) FROM user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User... users);
}
