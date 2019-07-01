package com.doaing.pigpen.home;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.doaing.common.util.Utils;
import com.doaing.pigpen.R;

public class MainActivity extends AppCompatActivity {
    private BlankViewModel mViewModel;
    private FragmentManager fragmentManager;
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private DFragment dFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(0);
                    return true;
                case R.id.navigation_attention:
                    showFragment(1);
                    return true;
                case R.id.navigation_chat:
                    showFragment(2);
                    return true;
                case R.id.navigation_notifications:
                    showFragment(3);
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.setAndroidNativeLightStatusBar(this, true);
        mViewModel = ViewModelProviders.of(MainActivity.this)
                .get(BlankViewModel.class);
        fragmentManager = getSupportFragmentManager();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(0);
    }

    public void showFragment(int index) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if (aFragment == null) {
                    aFragment = new AFragment();
                    ft.add(R.id.message, aFragment);
                }
                ft.show(aFragment);
                break;
            case 1:
                if (bFragment == null) {
                    bFragment = new BFragment();
                    ft.add(R.id.message, bFragment);
                }
                ft.show(bFragment);
                break;
            case 2:
                if (cFragment == null) {
                    cFragment = new CFragment();
                    ft.add(R.id.message, cFragment);
                }
                ft.show(cFragment);
                break;
            case 3:
                if (dFragment == null) {
                    dFragment = new DFragment();
                    ft.add(R.id.message, dFragment);
                }
                ft.show(dFragment);
                break;

            default:
                break;
        }
        ft.commit();
    }

    public void hideFragment(FragmentTransaction ft) {
        //如果不为空，就先隐藏起来
        if (aFragment != null) {
            ft.hide(aFragment);
        }
        if (bFragment != null) {
            ft.hide(bFragment);
        }
        if (cFragment != null) {
            ft.hide(cFragment);
        }
        if (dFragment != null) {
            ft.hide(dFragment);
        }
    }

}
