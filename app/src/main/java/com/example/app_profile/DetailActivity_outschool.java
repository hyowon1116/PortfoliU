package com.example.app_profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_outschool;
import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.User_outschool;
import com.example.app_profile.Room.User_school;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity_outschool extends AppCompatActivity {
    private final int REQUEST_CODE = 200;

    private EditText detailTitle;
    private ImageView detailImage;
    private EditText detailDes;
    private EditText detailDes2;
    private EditText detailDes3;
    private AppDatabase_outschool db;

    private FloatingActionButton exit;
    private FloatingActionButton update;

    private int id;
    private String title;
    private String date;
    private String exp;
    private String des;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_outschool);

        initialized();


        // 수정
        update.setOnClickListener(v -> {
            //문제점 : 그냥 그대로 저장이된다.
            title = detailTitle.getText().toString();
            date = detailDes.getText().toString();
            exp = detailDes2.getText().toString();
            des = detailDes3.getText().toString();
            System.out.println("####1" + title + " " +date+ " ~ "+ exp+ " "+des + " " + id);
            db.userDao().update(title, date, exp, des, id);
            finish();
        });
        //그냥 종료
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
    }

    private void initialized() {
        update = findViewById(R.id.update_outschool);
        exit = findViewById(R.id.exit_outschool);
        detailTitle = findViewById(R.id.detailTitle_outschool);
        detailImage = findViewById(R.id.detailImage_outschool);
        detailDes = findViewById(R.id.detailDes_outschool);
        detailDes2 = findViewById(R.id.detailDes2_outschool);
        detailDes3 = findViewById(R.id.detailDes3_outschool);
        db = AppDatabase_outschool.getInstance(this);

        User_outschool detail = getIntent().getParcelableExtra("data");

        id = detail.getId();
        title = detail.getTitle();
        date = detail.getDate();
        exp = detail.getExp();
        des = detail.getDes();

        detailTitle.setText(title);
        detailDes.setText(date);
        detailDes2.setText(exp);
        detailDes3.setText(des);
    }


}
