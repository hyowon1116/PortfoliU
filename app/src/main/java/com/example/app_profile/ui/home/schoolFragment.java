package com.example.app_profile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.app_profile.R;

public class schoolFragment extends Fragment {
    HomeFragment homeFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeFragment = new HomeFragment();

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.home_school, container, false);


        return rootview;
    }
}
