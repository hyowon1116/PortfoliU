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

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    private AppDatabase_dday db;
    private TextView dday;
    private String title;

    // 현재 날짜를 알기 위해 사용
    Calendar calendar;
    int currentYear, currentMonth, currentDay;

    // Millisecond 형태의 하루(24 시간)
    private final int ONE_DAY = 24 * 60 * 60 * 1000;


    @Override
    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);

        dday = findViewById(R.id.textView0);
        calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = (calendar.get(Calendar.MONTH));
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        db = AppDatabase_dday.getInstance(this);
        int size = db.userDao().getDataCount();
        if(size>0){

            User_dday day = db.userDao().getAll().get(size-1);

            dday.setText(getDday(day.getDyear(), day.getDmonth(), day.getDdate()));
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

    private String getDday(int mYear, int mMonthOfYear, int mDayOfMonth) {

        // D-day 설정
        final Calendar ddayCalendar = Calendar.getInstance();
        ddayCalendar.set(mYear, mMonthOfYear, mDayOfMonth);

        // D-day 를 구하기 위해 millisecond 으로 환산하여 d-day 에서 today 의 차를 구한다.
        final long dday = ddayCalendar.getTimeInMillis() / ONE_DAY;
        final long today = Calendar.getInstance().getTimeInMillis() / ONE_DAY;
        long result = dday - today;

        // 출력 시 d-day 에 맞게 표시
        String strFormat;
        if (result > 0) {
            strFormat = "D-%d";
        } else if (result == 0) {
            strFormat = "Today";
        } else {
            result *= -1;
            strFormat = "D+%d";
        }

        final String strCount = (String.format(strFormat, result));


        return strCount;
    }
}