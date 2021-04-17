package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_todo {

    @Insert
    void insert(User_todo user);

    @Update
    void update(User_todo user);

    @Query("UPDATE Todo SET user_title = :t, user_lec = :l, user_date = :da, user_des = :d WHERE user_id =:id")
    void update(String t, String l, String da, String d, int id);

    @Delete
    void delete(User_todo user);

    @Query("SELECT * FROM  Todo")
    List<User_todo> getAll();

    @Query("DELETE FROM Todo")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM Todo")
    int getDataCount();
}
