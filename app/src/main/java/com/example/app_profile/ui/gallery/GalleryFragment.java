package com.example.app_profile.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_profile.R;
import com.example.app_profile.Room.AppDatabase_bingo;
import com.example.app_profile.Room.AppDatabase_levelcnt;
import com.example.app_profile.Room.User_bingo;
import com.example.app_profile.Room.User_levelcnt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private int Count;
    private int level;
    private AppDatabase_levelcnt db;
    private AppDatabase_bingo db1;
    private List<User_bingo> user_bingo;
    private FloatingActionButton Btn;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        Button bingo1 = (Button) root.findViewById(R.id.bingo1);
        Button bingo2 = (Button) root.findViewById(R.id.bingo2);
        Button bingo3 = (Button) root.findViewById(R.id.bingo3);
        Button bingo4 = (Button) root.findViewById(R.id.bingo4);
        Button bingo5 = (Button) root.findViewById(R.id.bingo5);
        Button bingo6 = (Button) root.findViewById(R.id.bingo6);
        Button bingo7 = (Button) root.findViewById(R.id.bingo7);
        Button bingo8 = (Button) root.findViewById(R.id.bingo8);
        Button bingo9 = (Button) root.findViewById(R.id.bingo9);
        initialized(1, bingo1);
        initialized(2, bingo2);
        initialized(3, bingo3);
        initialized(4, bingo4);
        initialized(5, bingo5);
        initialized(6, bingo6);
        initialized(7, bingo7);
        initialized(8, bingo8);
        initialized(9, bingo9);

        TextView bingoCnt = (TextView) root.findViewById(R.id.bingoCnt);
        Button.OnClickListener clickListener;

        db = AppDatabase_levelcnt.getInstance(this.getContext());
        db1 = AppDatabase_bingo.getInstance(this.getContext());
        Btn = root.findViewById(R.id.formatBtn);

        level = db1.userDao().getDataCount();
        bingoCnt.setText("레벨 "+level);

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        user_bingo = AppDatabase_bingo.getInstance(getContext()).userDao().getAll();


        clickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                int c1 = bingo1.getCurrentTextColor();
                int c2 = bingo2.getCurrentTextColor();
                int c3 = bingo3.getCurrentTextColor();
                int c4 = bingo4.getCurrentTextColor();
                int c5 = bingo5.getCurrentTextColor();
                int c6 = bingo6.getCurrentTextColor();
                int c7 = bingo7.getCurrentTextColor();
                int c8 = bingo8.getCurrentTextColor();
                int c9 = bingo9.getCurrentTextColor();
                String color1 = String.format("#%06X", (0xFFFFFF & c1));
                String color2 = String.format("#%06X", (0xFFFFFF & c2));
                String color3 = String.format("#%06X", (0xFFFFFF & c3));
                String color4 = String.format("#%06X", (0xFFFFFF & c4));
                String color5 = String.format("#%06X", (0xFFFFFF & c5));
                String color6 = String.format("#%06X", (0xFFFFFF & c6));
                String color7 = String.format("#%06X", (0xFFFFFF & c7));
                String color8 = String.format("#%06X", (0xFFFFFF & c8));
                String color9 = String.format("#%06X", (0xFFFFFF & c9));
                int beforeCount = Count;
                int beforelevel = level;

                switch (view.getId()) {
                    case R.id.bingo1:
                        bingo1.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo1.setTextColor(Color.BLACK);
                        bingo1.setEnabled(false);
                        click("1");
                        if (color2.equals("#000000") && color3.equals("#000000")) {count();}
                        if (color4.equals("#000000") && color7.equals("#000000")) {count();}
                        if (color5.equals("#000000") && color9.equals("#000000")) {count();}
                        break;

                    case R.id.bingo2:
                        bingo2.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo2.setTextColor(Color.BLACK);
                        bingo2.setEnabled(false);
                        click("2");
                        if (color1.equals("#000000") && color3.equals("#000000")) {count();}
                        if (color5.equals("#000000") && color8.equals("#000000")) {count();}
                        break;

                    case R.id.bingo3:
                        bingo3.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo3.setTextColor(Color.BLACK);
                        bingo3.setEnabled(false);
                        click("3");
                        if (color1.equals("#000000") && color2.equals("#000000")) {count();}
                        if (color5.equals("#000000") && color7.equals("#000000")) {count();}
                        if (color6.equals("#000000") && color9.equals("#000000")) {count();}
                        break;

                    case R.id.bingo4:
                        bingo4.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo4.setTextColor(Color.BLACK);
                        bingo4.setEnabled(false);
                        click("4");
                        if (color1.equals("#000000") && color7.equals("#000000")) {count();}
                        if (color5.equals("#000000") && color6.equals("#000000")) {count();}
                        break;

                    case R.id.bingo5:
                        bingo5.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo5.setTextColor(Color.BLACK);
                        bingo5.setEnabled(false);
                        click("5");
                        if (color1.equals("#000000") && color9.equals("#000000")) {count();}
                        if (color2.equals("#000000") && color8.equals("#000000")) {count();}
                        if (color3.equals("#000000") && color7.equals("#000000")) {count();}
                        if (color4.equals("#000000") && color6.equals("#000000")) {count();}
                        break;

                    case R.id.bingo6:
                        bingo6.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo6.setTextColor(Color.BLACK);
                        bingo6.setEnabled(false);
                        click("6");
                        if (color3.equals("#000000") && color9.equals("#000000")) {count();}
                        if (color4.equals("#000000") && color5.equals("#000000")) {count();}
                        break;

                    case R.id.bingo7:
                        bingo7.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo7.setTextColor(Color.BLACK);
                        bingo7.setEnabled(false);
                        click("7");
                        if (color1.equals("#000000") && color4.equals("#000000")) {count();}
                        if (color3.equals("#000000") && color5.equals("#000000")) {count();}
                        if (color8.equals("#000000") && color9.equals("#000000")) {count();}
                        break;

                    case R.id.bingo8:
                        bingo8.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo8.setTextColor(Color.BLACK);
                        bingo8.setEnabled(false);
                        click("8");
                        if (color2.equals("#000000") && color5.equals("#000000")) {count();}
                        if (color7.equals("#000000") && color9.equals("#000000")) {count();}
                        break;

                    case R.id.bingo9:
                        bingo9.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo9.setTextColor(Color.BLACK);
                        bingo9.setEnabled(false);
                        click("9");
                        if (color1.equals("#000000") && color5.equals("#000000")) {count();}
                        if (color3.equals("#000000") && color6.equals("#000000")) {count();}
                        if (color7.equals("#000000") && color8.equals("#000000")) {count();}
                        break;
                }

                // 이전보다 카운트가 증가했을 경우
                if (Count > beforeCount) {
                    Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();

                    if(Count == 2) {
                        Toast.makeText(getActivity(),"사진 변경 기능이 해제되었습니다",Toast.LENGTH_SHORT).show();
                    }
                }
                if(level>beforelevel){
                    bingoCnt.setText("레벨 "+level);
                }
            }
        };

        bingo1.setOnClickListener(clickListener);
        bingo2.setOnClickListener(clickListener);
        bingo3.setOnClickListener(clickListener);
        bingo4.setOnClickListener(clickListener);
        bingo5.setOnClickListener(clickListener);
        bingo6.setOnClickListener(clickListener);
        bingo7.setOnClickListener(clickListener);
        bingo8.setOnClickListener(clickListener);
        bingo9.setOnClickListener(clickListener);
        
        // 초기화 버튼 클릭 이벤트
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.userDao().deleteAll();
                db1.userDao().deleteAll();

                bingo1.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo1.setTextColor(Color.WHITE);
                bingo1.setEnabled(true);
                bingo2.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo2.setTextColor(Color.WHITE);
                bingo2.setEnabled(true);
                bingo3.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo3.setTextColor(Color.WHITE);
                bingo3.setEnabled(true);
                bingo4.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo4.setTextColor(Color.WHITE);
                bingo4.setEnabled(true);
                bingo5.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo5.setTextColor(Color.WHITE);
                bingo5.setEnabled(true);
                bingo6.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo6.setTextColor(Color.WHITE);
                bingo6.setEnabled(true);
                bingo7.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo7.setTextColor(Color.WHITE);
                bingo7.setEnabled(true);
                bingo8.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo8.setTextColor(Color.WHITE);
                bingo8.setEnabled(true);
                bingo9.setBackgroundColor(Color.parseColor("#9F89D1"));
                bingo9.setTextColor(Color.WHITE);
                bingo9.setEnabled(true);

                Toast.makeText(getActivity(),"빙고판이 초기화되었습니다",Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    public void count(){
        User_levelcnt bingo = new User_levelcnt(1);
        db.userDao().insert(bingo);
        Count =db.userDao().getDataCount();

    }

    public void initialized(int i, Button button){
        user_bingo = AppDatabase_bingo.getInstance(getContext()).userDao().getAll();
        int size = user_bingo.size();
        Log.i("block","size is"+size);
        for(int y=0;y<size;y++){
            Log.i("block","tag is"+user_bingo.get(y).getTag());
            if(user_bingo.get(y).getTag().equals(""+i)){
                button.setBackgroundColor(Color.parseColor("#0000FF"));
                button.setTextColor(Color.BLACK);
                button.setEnabled(false);
            }
        }
    }

    public void click(String button){
        User_bingo memo = new User_bingo(button);
        db1.userDao().insert(memo);
        Log.i("block","clickfuntion");
        level =db1.userDao().getDataCount();
    }
}
