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

    @Query("UPDATE Timetable SET user_tag = :t, user_lec = :l, user_prof = :p WHERE user_id =:id")
    void update(String t, String l, String p,int id);

    @Delete
    void delete(User_timetable user);

    @Query("SELECT * FROM  Timetable")
    List<User_timetable> getAll();

    @Query("DELETE FROM Timetable")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM Timetable")
    int getDataCount();
}
