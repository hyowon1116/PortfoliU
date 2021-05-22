package com.example.app_profile.ui.notifications;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_profile.R;
import com.example.app_profile.Room.AppDatabase_timetable;
import com.example.app_profile.Room.User_timetable;
import com.example.app_profile.SaveMemoActivity_timetable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private final int REQUEST_CODE = 200;
    private TextView[] textViews = new TextView[40];
    private FloatingActionButton ClassBtn;

    private List<User_timetable> users;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        ClassBtn = (FloatingActionButton) root.findViewById(R.id.ClassBtn);
        users = AppDatabase_timetable.getInstance(getContext()).userDao().getAll();


        int size = users.size();
        for(int i = 0; i < size; i++){


            textViews[i] = root.findViewWithTag(users.get(i).getTag());
            textViews[i].setText(users.get(i).getLec());

            textViews[i].setTextColor(Color.BLACK);
            textViews[i].setBackground(getResources().getDrawable(R.drawable.table_item));

        }


        //InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        // 버튼 이벤트
        ClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move();

            }
        });




        return root;
    }


    private void move() {
        Intent intent = new Intent(getActivity().getApplicationContext(), SaveMemoActivity_timetable.class);
        startActivity(intent);
    }

    public void onStart() {
        users = AppDatabase_timetable.getInstance(getContext()).userDao().getAll();

        super.onStart();

    }
}