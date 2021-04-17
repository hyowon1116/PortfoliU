package com.example.app_profile.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_profile.R;
import com.example.app_profile.Recycler.RecyclerAdapter_competition;
import com.example.app_profile.Recycler.RecyclerAdapter_school;
import com.example.app_profile.Room.AppDatabase_competition;
import com.example.app_profile.Room.AppDatabase_school;
import com.example.app_profile.Room.User_competition;
import com.example.app_profile.Room.User_school;
import com.example.app_profile.SaveMemoActivity_competition;
import com.example.app_profile.SaveMemoActivity_school;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class competitionFragment extends Fragment {
    HomeFragment homeFragment;

    private final int SAVE_MEMO_ACTIVITY = 1;
    private FloatingActionButton add;

    //리사이클러 뷰
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter_competition adapter;
    private List<User_competition> users;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeFragment = new HomeFragment();

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.home_competition, container, false);
        add = rootview.findViewById(R.id.addMemo_competition);

        recyclerView = rootview.findViewById(R.id.mainRecyclerView_competition);
        linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new RecyclerAdapter_competition();

        users = AppDatabase_competition.getInstance(getContext()).userDao().getAll();
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
        Intent intent = new Intent(getActivity().getApplicationContext(), SaveMemoActivity_competition.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        users = AppDatabase_competition.getInstance(getContext()).userDao().getAll();
        adapter.addItems((ArrayList) users);
        super.onStart();
    }
}
