package com.doaing.pigpen.home;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.doaing.common.util.Utils;
import com.doaing.pigpen.R;
import com.doaing.pigpen.other.SlideFinishActivityLayout;

public class PublishActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.set360dpDensity(this);
        Utils.setAndroidNativeLightStatusBar(this,true);
        setContentView(R.layout.activity_publish);
        final SlideFinishActivityLayout slideFinishActivityLayout = findViewById(R.id.slide);
        findViewById(R.id.cancel_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideFinishActivityLayout.smoothScrollToEnd();
            }
        });
    }
}
