package com.example.app_profile.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_profile.R;
import com.example.app_profile.Recycler.RecyclerAdapter;
import com.example.app_profile.Recycler.RecyclerAdapter_todo;
import com.example.app_profile.Room.AppDatabase;
import com.example.app_profile.Room.AppDatabase_todo;
import com.example.app_profile.Room.User;
import com.example.app_profile.Room.User_todo;
import com.example.app_profile.SaveMemoActivity;
import com.example.app_profile.SaveMemoActivity_competition;
import com.example.app_profile.SaveMemoActivity_todo;
import com.example.app_profile.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private final int SAVE_MEMO_ACTIVITY = 1;
    private FloatingActionButton add;

    //리사이클러 뷰
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter_todo adapter;
    private List<User_todo> users;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard, container, false);
        add = rootview.findViewById(R.id.addMemo_todo);

        recyclerView = rootview.findViewById(R.id.mainRecyclerView_todo);
        linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerAdapter_todo();

        users = AppDatabase_todo.getInstance(getContext()).userDao().getAll();
        int size = users.size();
        for(int i = 0; i < size; i++){
            adapter.addItem(users.get(i));
        }

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        add.setOnClickListener(v -> {
            move();
        });


        return rootview;
    }

    private void move() {
        Intent intent = new Intent(getActivity().getApplicationContext(), SaveMemoActivity_todo.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        users = AppDatabase_todo.getInstance(getContext()).userDao().getAll();
        adapter.addItems((ArrayList) users);
        super.onStart();
    }
}