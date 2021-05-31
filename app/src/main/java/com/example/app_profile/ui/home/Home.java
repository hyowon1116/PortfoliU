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
import com.example.app_profile.Recycler.RecyclerAdapter_foreign;
import com.example.app_profile.Room.AppDatabase_foreign;
import com.example.app_profile.Room.User_foreign;
import com.example.app_profile.SaveMemoActivity_foreign;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    HomeFragment homeFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeFragment = new HomeFragment();
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.home_foreign, container, false);

        return rootview;
    }
}
