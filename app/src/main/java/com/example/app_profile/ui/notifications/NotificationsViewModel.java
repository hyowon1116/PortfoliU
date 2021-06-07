package com.example.app_profile.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app_profile.Room.User_timetable;

import java.util.ArrayList;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ArrayList<User_timetable> userData = new ArrayList<>();

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText(User_timetable user) {
        mText.setValue(user.getLec());
        return mText;
    }
}
