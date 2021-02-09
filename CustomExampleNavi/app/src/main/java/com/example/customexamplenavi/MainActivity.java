package com.example.customexamplenavi;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);

        Button btn_open = (Button) findViewById(R.id.btn_open);
        //열기 버튼을 누르면 네비 메뉴가 뜬다.
        btn_open.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.addDrawerListener(lintener);
        drawerView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    DrawerLayout.DrawerListener lintener = new DrawerLayout.DrawerListener() {
        //슬라이드 됬을 떄
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }
        //열렸을 때
        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }
        //닫혔을 때
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }
        //상태가 바뀌었을
        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}