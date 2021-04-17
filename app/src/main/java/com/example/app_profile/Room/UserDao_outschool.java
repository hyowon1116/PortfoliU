package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_outschool {

    @Insert
    void insert(User_outschool user);

    @Update
    void update(User_outschool user);

    @Query("UPDATE memoTable_outschool SET user_title = :t, user_date = :da, user_expire = :e, user_des = :d WHERE user_id =:id")
    void update(String t, String da, String e, String d, int id);

    @Delete
    void delete(User_outschool user);

    @Query("SELECT * FROM  memoTable_outschool")
    List<User_outschool> getAll();

    @Query("DELETE FROM memoTable_outschool")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM memoTable_outschool")
    int getDataCount();
}
