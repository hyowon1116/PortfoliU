package com.example.app_profile.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.app_profile.Room.AppDatabase;
import com.example.app_profile.Room.User;
import com.example.app_profile.SaveMemoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    certificateFragment CertificateFragment;
    foreignFragment ForeignFragment;
    schoolFragment SchoolFragment;
    outschoolFragment OutschoolFragment;
    competitionFragment CompetitionFragment;
    Home home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);

        CertificateFragment = new certificateFragment();
        ForeignFragment = new foreignFragment();
        SchoolFragment = new schoolFragment();
        OutschoolFragment = new outschoolFragment();
        CompetitionFragment = new competitionFragment();
        home = new Home();

        Button button1 = (Button) rootview.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().replace(R.id.home_list, CertificateFragment).commit();
            }
        });

        Button button2 = (Button) rootview.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().replace(R.id.home_list, ForeignFragment).commit();
            }
        });

        Button button3 = (Button) rootview.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().replace(R.id.home_list, SchoolFragment).commit();
            }
        });

        Button button4 = (Button) rootview.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().replace(R.id.home_list, OutschoolFragment).commit();
            }
        });

        Button button5 = (Button) rootview.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().replace(R.id.home_list, CompetitionFragment).commit();
            }
        });

        return rootview;
    }
}
