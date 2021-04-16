package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_foreign {

    @Insert
    void insert(User_foreign user);

    @Update
    void update(User_foreign user);

    @Query("UPDATE memoTable_foreign SET user_title = :t, user_des = :d WHERE user_id =:id")
    void update(String t, String d, int id);

    @Delete
    void delete(User_foreign user);

    @Query("SELECT * FROM  memoTable_foreign")
    List<User_foreign> getAll();

    @Query("DELETE FROM memoTable_foreign")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM memoTable_foreign")
    int getDataCount();
}
