package com.doaing.pigpen.other;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.doaing.common.util.Utils;
import com.doaing.pigpen.R;

import static android.support.v4.view.WindowCompat.FEATURE_ACTION_BAR;

public class Main2Activity extends AppCompatActivity {
    private float lastPointX;
    private float lastPointY;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Utils.setAndroidNativeLightStatusBar(this,true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
