package com.example.app_profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class DetailActivity_todo extends AppCompatActivity {
    private final int REQUEST_CODE = 200;

    private EditText detailTitle;
    private ImageView detailImage;
    private EditText detailDes;
    private EditText detailDes2;
    private EditText detailDes3;
    private AppDatabase_todo db;
    private AppDatabase_finishcnt db2;


    private FloatingActionButton exit;
    private FloatingActionButton update;

    private int id;
    private String title;
    private String date;
    private String lec;
    private String des;

    User_todo detail;
    private ArrayList<User_todo> userData = new ArrayList<>();
    private ArrayList<User_finishcnt> userData2 = new ArrayList<>();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_todo);

        initialized();


        // 수정
        update.setOnClickListener(v -> {
            //문제점 : 그냥 그대로 저장이된다.
            title = detailTitle.getText().toString();
            date = detailDes.getText().toString();
            lec = detailDes2.getText().toString();
            des = detailDes3.getText().toString();
            System.out.println("####1" + title + " " +date+ " ~ "+ lec+ " "+des + " " + id);
            db.userDao().update(title, date, lec, des, id);
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
    }

    private void initialized() {
        update = findViewById(R.id.update_todo);
        exit = findViewById(R.id.exit_todo);
        detailTitle = findViewById(R.id.detailTitle_todo);
        detailImage = findViewById(R.id.detailImage_todo);
        detailDes = findViewById(R.id.detailDes_todo);
        detailDes2 = findViewById(R.id.detailDes2_todo);
        detailDes3 = findViewById(R.id.detailDes3_todo);
        db = AppDatabase_todo.getInstance(this);
        db2 = AppDatabase_finishcnt.getInstance(this);


        detail = getIntent().getParcelableExtra("data");

        id = detail.getId();
        title = detail.getTitle();
        date = detail.getDate();
        lec = detail.getLec();
        des = detail.getDes();

        detailTitle.setText(title);
        detailDes.setText(date);
        detailDes2.setText(lec);
        detailDes3.setText(des);
    }


}
