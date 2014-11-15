package com.jzap.mymultithreadingapp;

import android.util.Log;
import android.view.View;
import android.app.Activity;

/**
 * Created by Justin on 11/1/2014.
 */
public class PostRunnable implements Runnable {

    public SpecialEditText mView;

    public PostRunnable(View view) {
        mView = (SpecialEditText) view;
        Log.i("PostRunnable", "PostRunnable Constructor called");
    }

    @Override
    public void run() {
        Log.i("PostRunnable/run", "Entered");
        mView.post(new Runnable() {
            @Override
            public void run() {
                Log.i("PostRunnable/run/run", "Entered");
                mView.setText("SUCCESS");
            }
        });

    }
}
