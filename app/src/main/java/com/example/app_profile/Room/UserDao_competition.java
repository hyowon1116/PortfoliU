package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_competition {

    @Insert
    void insert(User_competition user);

    @Update
    void update(User_competition user);

    @Query("UPDATE memoTable_competition SET user_title = :t, user_date = :da, user_expire = :e, user_des = :d WHERE user_id =:id")
    void update(String t, String da, String e, String d, int id);

    @Delete
    void delete(User_competition user);

    @Query("SELECT * FROM  memoTable_competition")
    List<User_competition> getAll();

    @Query("DELETE FROM memoTable_competition")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM memoTable_competition")
    int getDataCount();
}
