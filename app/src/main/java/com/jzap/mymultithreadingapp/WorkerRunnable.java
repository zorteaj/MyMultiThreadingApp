package com.jzap.mymultithreadingapp;

import android.view.View;

/**
 * Created by Justin on 10/29/2014.
 */
public class WorkerRunnable implements Runnable {

    public WorkerRunnable(View view) {
        mView = view;
    }

    private View mView;

    @Override
    public void run() {
        WorkerClass sWorker = WorkerClass.getInstance();
        sWorker.handleState(mView);
    }
}
