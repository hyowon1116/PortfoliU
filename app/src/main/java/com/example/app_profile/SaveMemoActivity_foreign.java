package com.example.app_profile;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_profile.Room.AppDatabase;
import com.example.app_profile.Room.AppDatabase_foreign;
import com.example.app_profile.Room.User;
import com.example.app_profile.Room.User_foreign;

public class SaveMemoActivity_foreign extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private EditText description;
    private EditText description2;
    private EditText description3;
    private AppDatabase_foreign db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_memo_foreign);

        initialized();
    }

    private void initialized() {
        description = findViewById(R.id.description_foreign);
        description2 = findViewById(R.id.description2_foreign);
        description3 = findViewById(R.id.description3_foreign);

        db = AppDatabase_foreign.getInstance(this);

    }

    //메모저장하는 버튼
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_memo_menu_foreign, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save_foreign:
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
            User_foreign memo = new User_foreign(s, description.getText().toString(), description2.getText().toString(), description3.getText().toString());
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
