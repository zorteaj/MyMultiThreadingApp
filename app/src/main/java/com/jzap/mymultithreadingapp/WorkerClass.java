package com.jzap.mymultithreadingapp;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

/**
 * Created by Justin on 10/25/2014.
 */
public class WorkerClass {

    final String TAG = "WorkerClass";

    static WorkerClass sWorker = new WorkerClass();

    private Handler mHandler;

    private WorkerClass() {
        /*
        * Defining a Handler object that's attached to the UI thread by passing the
        * Main Looper, which itself is attached to the UI thread, to the Handler's constructor
        *
        * OR:
        *
        * Runs on UI Thread because class's constructor first invoked by object on UI Thread??
        */
        mHandler = new Handler(Looper.getMainLooper()) {

            // Defines the operations to perform when the Handler receives a new Message to process
            @Override
            public void handleMessage(Message inputMessage) {
                int what = inputMessage.what;
                SpecialEditText mSpecialEditText = (SpecialEditText) inputMessage.obj;
                switch(what) {
                    case 0 : mSpecialEditText.setBackgroundColor(Color.CYAN);
                        break;
                    case 1 : mSpecialEditText.setBackgroundColor(Color.YELLOW);
                        break;
                    default :
                        break;
                }
            }
        };
    }

    public static WorkerClass getInstance() {
        return sWorker;
    }

    public void handleState(View view) {
        int what;
        for (int i = 0; i < 9; i++) {
            what = i%2;
            Log.i(TAG, String.valueOf(what));
            mHandler.obtainMessage(what, view).sendToTarget();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* mHandler.obtainMessage(0, view).sendToTarget();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mHandler.obtainMessage(1, view).sendToTarget();
        */
    }
}

