package com.learnandroid.superpoohh.ballanimation.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.learnandroid.superpoohh.ballanimation.ListActivity;
import com.learnandroid.superpoohh.ballanimation.R;



public class SplashScreen extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;
    long delay_time;
    long time = 1000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_spash_screen);

        handler = new Handler();

        runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }


    public void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }

}
