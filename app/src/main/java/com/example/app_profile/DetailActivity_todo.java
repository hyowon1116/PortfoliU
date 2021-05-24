package com.example.app_profile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_finishcnt;
import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.AppDatabase_todo;
import com.example.app_profile.Room.User_finishcnt;
import com.example.app_profile.Room.User_school;
import com.example.app_profile.Room.User_todo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class DetailActivity_todo extends AppCompatActivity {
    private final int REQUEST_CODE = 200;

    private EditText detailTitle;
    private ImageView detailImage;
    private Button pick;
    private TextView day;
    private EditText detailDes2;
    private EditText detailDes3;
    private AppDatabase_todo db;
    private AppDatabase_finishcnt db2;
    private AppDatabase_school db3;


    private FloatingActionButton exit;
    private FloatingActionButton update;
    private FloatingActionButton upload;

    private int id;
    private String title;
    private String lec;
    private String des;
    int yeart, montht, datet;

    Calendar calendar;
    int currentYear, currentMonth, currentDay;

    // Millisecond 형태의 하루(24 시간)
    private final int ONE_DAY = 24 * 60 * 60 * 1000;

    User_todo detail;
    private ArrayList<User_todo> userData = new ArrayList<>();
    private ArrayList<User_finishcnt> userData2 = new ArrayList<>();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_todo);

        initialized();

        //datePicker : 디데이 날짜 입력하는 버튼, 클릭시 DatePickerDialog 띄우기
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(DetailActivity_todo.this, endDateSetListen, (currentYear), (currentMonth), currentDay).show();
            }
        });

        // 수정
        update.setOnClickListener(v -> {
            //문제점 : 그냥 그대로 저장이된다.
            title = detailTitle.getText().toString();
            lec = detailDes2.getText().toString();
            des = detailDes3.getText().toString();

            System.out.println("####1" + title + " ~ "+ lec+ " "+des + " " + id);
            db.userDao().update(title, lec, yeart, montht, datet,  des, id);
            finish();
        });
        //그냥 종료
        exit.setOnClickListener(v -> {
            userData.remove(detail);
            db.userDao().delete(detail);
            User_finishcnt memo = new User_finishcnt(1);
            db2.userDao().insert(memo);
            Toast.makeText(getApplicationContext(),"과제를 완료하셨습니다.", Toast.LENGTH_LONG).show();

            finish();
        });
        //그냥 종료
        upload.setOnClickListener(v -> {

            userData.remove(detail);
            db.userDao().delete(detail);
            User_school memo2 = new User_school(title, day.getText().toString(), "", des);
            db3.userDao().insert(memo2);
            Toast.makeText(getApplicationContext(),"교내활동에 연동하였습니다.", Toast.LENGTH_LONG).show();

            finish();
        });
    }

    private void initialized() {
        update = findViewById(R.id.update_todo);
        exit = findViewById(R.id.exit_todo);
        upload = findViewById(R.id.upload_todo);

        detailTitle = findViewById(R.id.detailTitle_todo);
        detailImage = findViewById(R.id.detailImage_todo);
        day = findViewById(R.id.todo_edit_Date);
        pick = findViewById(R.id.todo_datePick);
        detailDes2 = findViewById(R.id.detailDes2_todo);
        detailDes3 = findViewById(R.id.detailDes3_todo);
        db = AppDatabase_todo.getInstance(this);
        db2 = AppDatabase_finishcnt.getInstance(this);
        db3 = AppDatabase_school.getInstance(this);
        calendar = Calendar.getInstance();

        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = (calendar.get(Calendar.MONTH));
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        //한국어 설정 (ex: date picker)
        Locale.setDefault(Locale.KOREAN);
        detail = getIntent().getParcelableExtra("data");

        id = detail.getId();
        title = detail.getTitle();
        lec = detail.getLec();
        des = detail.getDes();

        detailTitle.setText(title);
        day.setText(detail.getYear()+"년 "+ (detail.getMonth()+1)+"월 "+ detail.getDate()+"일");
        detailDes2.setText(lec);
        detailDes3.setText(des);
    }

    /** @brief getDday
     *  @date 2016-02-18
     *  @param mYear : 설정한 디데이 year, mMonthOfYear : 설정한 디데이 MonthOfYear, mDayOfMonth : 설정한 디데이 DayOfMonth
     *  @detail D-day 반환
     */
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

    /** @brief endDateSetListener
     *  @date 2016-02-18
     *  @detail DatePickerDialog띄우기, 종료일 저장, 기존에 입력한 값이 있으면 해당 데이터 설정후 띄우기
     */
    private DatePickerDialog.OnDateSetListener endDateSetListen = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            day.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");
            yeart = year;
            montht = monthOfYear;
            datet = dayOfMonth;
        }
    };

}
