package com.doaing.pigpen.other;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.doaing.common.util.Utils;
import com.doaing.pigpen.R;

public class Main2Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.set360dpDensity(this);
        Utils.setAndroidNativeLightStatusBar(this,true);
        setContentView(R.layout.activity_main2);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
