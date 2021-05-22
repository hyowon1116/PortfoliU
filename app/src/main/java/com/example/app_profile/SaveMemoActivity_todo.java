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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.AppDatabase_timetable;
import com.example.app_profile.Room.AppDatabase_todo;
import com.example.app_profile.Room.User_school;
import com.example.app_profile.Room.User_todo;

import java.util.ArrayList;

public class SaveMemoActivity_todo extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private EditText description;
    private Spinner description2;
    private EditText description3;
    private AppDatabase_todo db;
    private AppDatabase_timetable db1;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    public String Select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_memo_todo);

        initialized();

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);
        description2.setAdapter(arrayAdapter);
        description2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                Select = arrayList.get(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }

    private void initialized() {
        description = findViewById(R.id.description_todo);
        description2 = findViewById(R.id.description2_todo);
        description3 = findViewById(R.id.description3_todo);

        db = AppDatabase_todo.getInstance(this);
        db1 = AppDatabase_timetable.getInstance(this);


        arrayList = new ArrayList<>();
        int size = db1.userDao().getDataCount();
        for(int i=0;i<size;i++){
            arrayList.add(db1.userDao().getAll().get(i).getLec());
        }

        description2.setSelection(0);


    }

    //메모저장하는 버튼
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_memo_menu_todo, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save_todo:
                make_title();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void make_title() {

        EditText editText = new EditText(getApplicationContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("제목을 입력하세요");
        builder.setView(editText);

        builder.setPositiveButton("저장", (dialog, which) -> {
            String s = editText.getText().toString();
            // db에 저장하기
            User_todo memo = new User_todo(s, description.getText().toString(), Select.toString(), description3.getText().toString());
            db.userDao().insert(memo);
            Toast.makeText(getApplicationContext(),"저장되었습니다", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            finish();
        });

        builder.setNegativeButton("취소", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.show();
    }
}
