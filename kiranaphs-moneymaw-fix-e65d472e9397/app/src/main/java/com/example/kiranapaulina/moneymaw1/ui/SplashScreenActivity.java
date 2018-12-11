package com.example.kiranapaulina.moneymaw1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.kiranapaulina.moneymaw1.R;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();
        countDown();
    }

    private void countDown(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, JournalActivity.class));
                finish();
            }
        }, 3000);
    }


}
