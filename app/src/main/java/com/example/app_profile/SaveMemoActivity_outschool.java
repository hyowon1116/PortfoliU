package com.example.app_profile;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase_outschool;
import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.User_outschool;
import com.example.app_profile.Room.User_school;

public class SaveMemoActivity_outschool extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private EditText description;
    private EditText description2;
    private EditText description3;
    private AppDatabase_outschool db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_memo_outschool);

        initialized();
    }

    private void initialized() {
        description = findViewById(R.id.description_outschool);
        description2 = findViewById(R.id.description2_outschool);
        description3 = findViewById(R.id.description3_outschool);

        db = AppDatabase_outschool.getInstance(this);

    }

    //메모저장하는 버튼
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_memo_menu_outschool, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save_outschool:
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
            User_outschool memo = new User_outschool(s, description.getText().toString(), description2.getText().toString(), description3.getText().toString());
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
