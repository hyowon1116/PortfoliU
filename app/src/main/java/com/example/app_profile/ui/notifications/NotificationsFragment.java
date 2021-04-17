package com.example.app_profile.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_profile.MainActivity;
import com.example.app_profile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    public String daySelect;
    public Byte timeSelect;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        FloatingActionButton ClassBtn = (FloatingActionButton) root.findViewById(R.id.ClassBtn);
        LinearLayout page = (LinearLayout) root.findViewById(R.id.ClassPage);
        EditText lecName = (EditText) root.findViewById(R.id.lecture_name);
        EditText proName = (EditText) root.findViewById(R.id.professor_name);
        Spinner dayList = (Spinner) root.findViewById(R.id.dayList);
        Spinner timeList = (Spinner) root.findViewById(R.id.timeList);
        Button addBtn = (Button) root.findViewById(R.id.addBtn);
        Button cancelBtn = (Button) root.findViewById(R.id.cancelBtn);

        ArrayList<String> arrayList;
        ArrayAdapter<String> arrayAdapter;

        arrayList = new ArrayList<>();
        arrayList.add("월요일");
        arrayList.add("화요일");
        arrayList.add("수요일");
        arrayList.add("목요일");
        arrayList.add("금요일");

        arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);
        dayList.setAdapter(arrayAdapter);
        dayList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
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

        ArrayList<String> arrayList1;
        ArrayAdapter<String> arrayAdapter1;

        arrayList1 = new ArrayList<>();
        arrayList1.add("1교시(09:00 ~ 10:15)");
        arrayList1.add("2교시(10:30 ~ 11:45)");
        arrayList1.add("3교시(12:00 ~ 13:15)");
        arrayList1.add("4교시(13:30 ~ 14:45)");
        arrayList1.add("5교시(15:00 ~ 16:15)");
        arrayList1.add("6교시(16:30 ~ 17:45)");
        arrayList1.add("7교시(18:00 ~ 19:15)");
        arrayList1.add("8교시(19:30 ~ 20:45)");

        arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList1);
        timeList.setAdapter(arrayAdapter1);
        timeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
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

        ClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page.setVisibility(View.VISIBLE);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lecName.getText().toString().replace(" ", "").equals("")) {
                    Toast.makeText(getActivity(),"강의명을 입력하세요.",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "강의를 추가했습니다.", Toast.LENGTH_SHORT).show();
                    page.setVisibility(View.GONE);
                    TextView space = (TextView) root.findViewWithTag(daySelect + timeSelect);
                    space.setText(lecName.getText());
                    space.setTextColor(Color.BLACK);
                    space.setBackground(getResources().getDrawable(R.drawable.table_item));
                    lecName.setText("");
                    proName.setText("");
                    dayList.setSelection(0);
                    timeList.setSelection(0);
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"강의 추가를 취소했습니다.",Toast.LENGTH_SHORT).show();
                page.setVisibility(View.GONE);
                lecName.setText("");
                proName.setText("");
                dayList.setSelection(0);
                timeList.setSelection(0);
            }
        });
        return root;
    }
}
