package com.example.app_profile.Room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User_school.class}, version = 2, exportSchema = false)
public abstract class AppDatabase_school extends RoomDatabase {

    public abstract UserDao_school userDao();
    private static AppDatabase_school instance = null;


    //싱글톤
    //  error: AppDatabase() has private access in AppDatabase
    // 추상클래스에서 생성자를 private 하게 만들어 줄 필요가없음
    // 생성하면 위에와 같은 에러가 발생함
    /*private AppDatabase() {   }*/
    //데이터에 수정 하고싶을때에는 version을 하나 올리고, fallbackToDestructiveMigration 사용해야함

    public static synchronized AppDatabase_school getInstance(Context context){
        if(instance == null){
            instance =  Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase_school.class, "memo_Database_school")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
