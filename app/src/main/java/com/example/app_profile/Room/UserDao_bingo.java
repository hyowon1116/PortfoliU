package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_bingo {

    @Insert
    void insert(User_bingo user);

    @Update
    void update(User_bingo user);

    @Query("UPDATE BingoCnt SET user_tag = :t WHERE user_id =:id")
    void update(String t, int id);

    @Delete
    void delete(User_bingo user);

    @Query("SELECT * FROM  BingoCnt")
    List<User_bingo> getAll();

    @Query("DELETE FROM BingoCnt")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM BingoCnt")
    int getDataCount();
}
