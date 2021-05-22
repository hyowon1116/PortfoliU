package com.example.app_profile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_dday;
import com.example.app_profile.Room.AppDatabase_timetable;
import com.example.app_profile.Room.AppDatabase_todo;
import com.example.app_profile.Room.User_dday;
import com.example.app_profile.Room.User_todo;

public class SplashActivity extends AppCompatActivity {

    private AppDatabase_dday db;
    private TextView dday;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);

        dday = findViewById(R.id.textView0);

        db = AppDatabase_dday.getInstance(this);
        int size = db.userDao().getDataCount();
        if(size>0){

            User_dday detail = db.userDao().getAll().get(size-1);

            title = detail.getTitle();
            dday.setText(title);
        }



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}