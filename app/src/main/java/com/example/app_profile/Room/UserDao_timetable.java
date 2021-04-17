package com.example.app_profile.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao_timetable {

    @Insert
    void insert(User_timetable user);

    @Update
    void update(User_timetable user);

    @Query("UPDATE timetable SET user_lec = :l, user_prof = :p,  user_des = :d WHERE user_id =:id")
    void update(String l, String p, String d, int id);

    @Delete
    void delete(User_timetable user);

    @Query("SELECT * FROM  timetable")
    List<User> getAll();

    @Query("DELETE FROM timetable")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM timetable")
    int getDataCount();
}
