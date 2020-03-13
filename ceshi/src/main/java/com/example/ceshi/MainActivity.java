package com.example.ceshi;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ceshi.fragment.OwnFragment;
import com.example.ceshi.fragment.ZhuanTiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrame;
    private BottomNavigationView mNavigationview;
    private ZhuanTiFragment zhuanTiFragment;
    private OwnFragment ownFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        zhuanTiFragment = new ZhuanTiFragment();
        ownFragment = new OwnFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame,zhuanTiFragment).add(R.id.frame,ownFragment).show(zhuanTiFragment).hide(ownFragment).commit();

        mNavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.zhuanti:
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        fragmentTransaction1.show(zhuanTiFragment).hide(ownFragment).commit();
                        break;
                    case R.id.own:
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.show(ownFragment).hide(zhuanTiFragment).commit();
                }
                return false;
            }
        });
    }

    private void initView() {
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mNavigationview = (BottomNavigationView) findViewById(R.id.navigationview);
    }
}
