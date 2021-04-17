package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_school {

    @Insert
    void insert(User_school user);

    @Update
    void update(User_school user);

    @Query("UPDATE memoTable_school SET user_title = :t, user_date = :da, user_expire = :e, user_des = :d WHERE user_id =:id")
    void update(String t, String da, String e, String d, int id);

    @Delete
    void delete(User_school user);

    @Query("SELECT * FROM  memoTable_school")
    List<User_school> getAll();

    @Query("DELETE FROM memoTable_school")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM memoTable_school")
    int getDataCount();
}
