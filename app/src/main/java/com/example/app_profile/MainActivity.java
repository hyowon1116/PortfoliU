package com.example.app_profile;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    String imgName = "ForU.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View nav_header_view = navigationView.getHeaderView(0);
        ImageView imageView = nav_header_view.findViewById(R.id.imageView);

        // 프로필 사진 변경
        try {
            Intent intent = getIntent();
            Uri dataUri = Uri.parse(intent.getStringExtra("dataStr"));
            imageView.setImageURI(dataUri);

            ContentResolver resolver = getContentResolver();
            InputStream instream = resolver.openInputStream(dataUri);
            Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
            instream.close();
            saveBitmapToJpeg(imgBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String imgpath = getCacheDir() + "/" + imgName; // 내부 저장소에 저장되어 있는 이미지 경로
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            if (bm != null) {
                imageView.setImageBitmap(bm); // 내부 저장소에 저장된 이미지를 이미지뷰에 셋
            }
        } catch (Exception e) {
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round));
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void saveBitmapToJpeg(Bitmap bitmap) { // 선택한 이미지 내부 저장소에 저장
        File tempFile = new File(getCacheDir(), imgName); // 파일 경로와 이름 넣기
        try {
            tempFile.createNewFile(); // 자동으로 빈 파일을 생성하기
            FileOutputStream out = new FileOutputStream(tempFile); // 파일을 쓸 수 있는 스트림을 준비하기
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // compress 함수를 사용해 스트림에 비트맵을 저장하기
            out.close();    // 스트림 닫아주기
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
