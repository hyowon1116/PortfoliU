package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_levelcnt {

    @Insert
    void insert(User_levelcnt user);

    @Update
    void update(User_levelcnt user);

    @Query("UPDATE LvCnt SET user_bingo= :t WHERE user_id =:id")
    void update(int t, int id);

    @Delete
    void delete(User_levelcnt user);

    @Query("SELECT * FROM  LvCnt")
    List<User_levelcnt> getAll();

    @Query("DELETE FROM LvCnt")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM LvCnt")
    int getDataCount();
}
