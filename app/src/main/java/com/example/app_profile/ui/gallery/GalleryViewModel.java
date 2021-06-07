package com.example.app_profile.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TWO빙고 달성하면\n★추가 기능 OPEN★");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
