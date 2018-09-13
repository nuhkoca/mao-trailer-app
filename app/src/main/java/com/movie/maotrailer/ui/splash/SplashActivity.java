package com.movie.maotrailer.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.movie.maotrailer.R;
import com.movie.maotrailer.ui.main.MainActivity;
import com.movie.maotrailer.utils.AppUtils;

import dagger.android.support.DaggerAppCompatActivity;

public class SplashActivity extends DaggerAppCompatActivity {

    private Runnable mRunnable;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtils.hideStatusBar(this);

        mRunnable = () ->
                startActivity(new Intent(SplashActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        int duration = getResources().getInteger(R.integer.activity_delay_duration);
        mHandler = new Handler(getMainLooper());
        mHandler.postDelayed(mRunnable, duration);
    }

    @Override
    protected void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }

        super.onDestroy();
    }
}
