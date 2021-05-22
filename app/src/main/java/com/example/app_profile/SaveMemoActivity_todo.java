package com.example.app_profile;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.AppDatabase_timetable;
import com.example.app_profile.Room.AppDatabase_todo;
import com.example.app_profile.Room.User_dday;
import com.example.app_profile.Room.User_school;
import com.example.app_profile.Room.User_todo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SaveMemoActivity_todo extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private Spinner description2;
    private EditText description3;
    private AppDatabase_todo db;
    private AppDatabase_timetable db1;


    // 현재 날짜를 알기 위해 사용
    Calendar calendar;
    int currentYear, currentMonth, currentDay;

    // Millisecond 형태의 하루(24 시간)
    private final int ONE_DAY = 24 * 60 * 60 * 1000;

    TextView edit_endDate;
    Button datePick;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    public String Select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_memo_todo);

        initialized();

        //datePicker : 디데이 날짜 입력하는 버튼, 클릭시 DatePickerDialog 띄우기
        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SaveMemoActivity_todo.this, endDateSetListen, (currentYear), (currentMonth), currentDay).show();
            }
        });

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
        calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = (calendar.get(Calendar.MONTH));
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePick = (Button) findViewById(R.id.datePick);
        edit_endDate = (TextView) findViewById(R.id.edit_Date);

        //한국어 설정 (ex: date picker)
        Locale.setDefault(Locale.KOREAN);

        // 디데이 날짜 입력
        edit_endDate.setText(currentYear + "년 " + (currentMonth + 1) + "월 " + currentDay + "일");



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
            User_todo memo = new User_todo(s,  Select.toString(),edit_endDate.getText().toString(), description3.getText().toString());
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

    /** @brief endDateSetListener
     *  @date 2016-02-18
     *  @detail DatePickerDialog띄우기, 종료일 저장, 기존에 입력한 값이 있으면 해당 데이터 설정후 띄우기
     */
    private DatePickerDialog.OnDateSetListener endDateSetListen = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            edit_endDate.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");

        }
    };


}
