package com.example.zidingyi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyTitles mMyTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMyTitle = (MyTitles) findViewById(R.id.myTitle);
        mMyTitle.setActivity(this);
    }
}
