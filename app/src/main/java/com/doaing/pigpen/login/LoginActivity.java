package com.doaing.pigpen.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.doaing.common.util.Utils;
import com.doaing.pigpen.R;
import com.doaing.pigpen.home.MainActivity;
import com.doaing.pigpen.other.Main2Activity;

public class LoginActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setAndroidNativeLightStatusBar(this, true);
        Utils.set360dpDensity(this);
        setContentView(R.layout.activity_login);
     /*   Button loginBt = findViewById(R.id.login_bt);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });*/
    }

}
