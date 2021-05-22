package com.example.app_profile.ui.gallery;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

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
        Button.OnClickListener clickListener;

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

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

                switch (view.getId()) {
                    case R.id.bingo1:
                        bingo1.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo1.setTextColor(Color.BLACK);
                        bingo1.setEnabled(false);
                        if ((color2.equals("#000000") && color3.equals("#000000"))
                                || (color4.equals("#000000") && color7.equals("#000000"))
                                || (color5.equals("#000000") && color9.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo2:
                        bingo2.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo2.setTextColor(Color.BLACK);
                        bingo2.setEnabled(false);
                        if ((color1.equals("#000000") && color3.equals("#000000"))
                                || (color5.equals("#000000") && color8.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo3:
                        bingo3.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo3.setTextColor(Color.BLACK);
                        bingo3.setEnabled(false);
                        if ((color1.equals("#000000") && color2.equals("#000000"))
                                || (color6.equals("#000000") && color9.equals("#000000"))
                                || (color5.equals("#000000") && color7.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo4:
                        bingo4.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo4.setTextColor(Color.BLACK);
                        bingo4.setEnabled(false);
                        if ((color1.equals("#000000") && color7.equals("#000000"))
                                || (color5.equals("#000000") && color6.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo5:
                        bingo5.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo5.setTextColor(Color.BLACK);
                        bingo5.setEnabled(false);
                        if ((color1.equals("#000000") && color9.equals("#000000"))
                                || (color2.equals("#000000") && color8.equals("#000000"))
                                || (color3.equals("#000000") && color7.equals("#000000"))
                                || (color4.equals("#000000") && color6.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo6:
                        bingo6.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo6.setTextColor(Color.BLACK);
                        bingo6.setEnabled(false);
                        if ((color3.equals("#000000") && color9.equals("#000000"))
                                || (color4.equals("#000000") && color5.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo7:
                        bingo7.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo7.setTextColor(Color.BLACK);
                        bingo7.setEnabled(false);
                        if ((color1.equals("#000000") && color4.equals("#000000"))
                                || (color3.equals("#000000") && color5.equals("#000000"))
                                || (color8.equals("#000000") && color9.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo8:
                        bingo8.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo8.setTextColor(Color.BLACK);
                        bingo8.setEnabled(false);
                        if ((color2.equals("#000000") && color5.equals("#000000"))
                                || (color7.equals("#000000") && color9.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bingo9:
                        bingo9.setBackgroundColor(Color.parseColor("#0000FF"));
                        bingo9.setTextColor(Color.BLACK);
                        bingo9.setEnabled(false);
                        if ((color1.equals("#000000") && color5.equals("#000000"))
                                || (color3.equals("#000000") && color6.equals("#000000"))
                                || (color7.equals("#000000") && color8.equals("#000000"))) {
                            Toast.makeText(getActivity(),"빙고입니다!",Toast.LENGTH_SHORT).show();
                        }
                        break;
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

        return root;
    }
}
