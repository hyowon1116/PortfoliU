package com.example.app_profile;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.AppDatabase_timetable;
import com.example.app_profile.Room.User_school;
import com.example.app_profile.Room.User_timetable;
import com.example.app_profile.ui.notifications.NotificationsFragment;

import java.util.ArrayList;

public class SaveMemoActivity_timetable extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private EditText lec;
    private EditText prof;
    private Spinner dayList;
    private Spinner timeList;
    private Button addBtn ;
    private Button cancelBtn;
    private AppDatabase_timetable db;
    public String daySelect;
    public Byte timeSelect;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList1;
    ArrayAdapter<String> arrayAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_memo_timetable);

        initialized();


        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);
        dayList.setAdapter(arrayAdapter);
        dayList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                if (i == 0) {
                    daySelect = "monday";
                } else if (i == 1) {
                    daySelect = "tuesday";
                } else if (i == 2) {
                    daySelect = "wednesday";
                } else if (i == 3) {
                    daySelect = "thursday";
                } else {
                    daySelect = "friday";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                arrayList1);

        timeList.setAdapter(arrayAdapter1);
        timeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                if (i == 0) {
                    timeSelect = 0;
                } else if (i == 1) {
                    timeSelect = 1;
                } else if (i == 2) {
                    timeSelect = 2;
                } else if (i == 3) {
                    timeSelect = 3;
                } else if (i == 4) {
                    timeSelect = 4;
                } else if (i == 5) {
                    timeSelect = 5;
                } else if (i == 6) {
                    timeSelect = 6;
                } else {
                    timeSelect = 7;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        // 확인 버튼 이벤트
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lec.getText().toString().replace(" ", "").equals("")) {
                    Toast.makeText(getApplicationContext(),"강의명을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    //imm.hideSoftInputFromWindow(page.getWindowToken(), 0);
                    //page.setVisibility(View.GONE);

                    // db에 저장하기
                    User_timetable memo = new User_timetable((daySelect + timeSelect), lec.getText().toString(), prof.getText().toString());
                    db.userDao().insert(memo);
                    //AppDatabase_timetable.getInstance(getContext()).userDao().insert(memo);
                    Toast.makeText(getApplicationContext(), "강의를 추가했습니다.", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });

        // 취소 버튼 이벤트
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //imm.hideSoftInputFromWindow(page.getWindowToken(),0);
                //page.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "강의 추가를 취소했습니다.", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }

    private void initialized() {
        lec = findViewById(R.id.lecture_name);
        prof = findViewById(R.id.professor_name);
        dayList = findViewById(R.id.dayList);
        timeList = findViewById(R.id.timeList);
        addBtn = findViewById(R.id.addBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        arrayList = new ArrayList<>();
        arrayList.add("월요일");
        arrayList.add("화요일");
        arrayList.add("수요일");
        arrayList.add("목요일");
        arrayList.add("금요일");

        arrayList1 = new ArrayList<>();
        arrayList1.add("1교시(09:00 ~ 10:15)");
        arrayList1.add("2교시(10:30 ~ 11:45)");
        arrayList1.add("3교시(12:00 ~ 13:15)");
        arrayList1.add("4교시(13:30 ~ 14:45)");
        arrayList1.add("5교시(15:00 ~ 16:15)");
        arrayList1.add("6교시(16:30 ~ 17:45)");
        arrayList1.add("7교시(18:00 ~ 19:15)");
        arrayList1.add("8교시(19:30 ~ 20:45)");

        db = AppDatabase_timetable.getInstance(this);

        lec.setText("");
        prof.setText("");
        dayList.setSelection(0);
        timeList.setSelection(0);


    }


}
