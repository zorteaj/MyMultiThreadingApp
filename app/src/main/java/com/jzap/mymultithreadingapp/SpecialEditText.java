package com.jzap.mymultithreadingapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Justin on 10/25/2014.
 */
public class SpecialEditText extends EditText {

    static final int HANDLER_MODE = 0;
    static final int POST_MODE = 1;

    private WorkerClass mWorkerClass;

    public SpecialEditText(Context context) {
        super(context);
    }

    public SpecialEditText (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpecialEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void doStuff(int mode) {
        if (mode == HANDLER_MODE) {
            new Thread(new WorkerRunnable(this)).start();
        } else if (mode == POST_MODE) {
            new Thread(new PostRunnable(this)).start();
        }
    }
}
