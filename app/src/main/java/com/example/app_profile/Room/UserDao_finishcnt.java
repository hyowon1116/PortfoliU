package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_finishcnt {

    @Insert
    void insert(User_finishcnt user);

    @Update
    void update(User_finishcnt user);

    @Query("UPDATE Cnt SET user_finish = :t WHERE user_id =:id")
    void update(int t, int id);

    @Delete
    void delete(User_finishcnt user);

    @Query("SELECT * FROM  Cnt")
    List<User_finishcnt> getAll();

    @Query("DELETE FROM Cnt")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM Cnt")
    int getDataCount();
}
