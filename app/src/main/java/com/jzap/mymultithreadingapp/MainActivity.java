package com.jzap.mymultithreadingapp;

import android.os.*;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    RelativeLayout mainRelativeLayout;
    SpecialEditText mSpecialEditText;
    SpecialEditText mSpecialEditText2;
    RelativeLayout.LayoutParams mLayoutParams;
    RelativeLayout.LayoutParams mLayoutParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // (new Thread(new myRunnable())).start();

        setContentView(R.layout.activity_main);

        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        mSpecialEditText = new SpecialEditText(this);
        mSpecialEditText.setId(View.generateViewId());
        mSpecialEditText2 = new SpecialEditText(this);

        mLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        mLayoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        //Log.i("MainActivity", String.valueOf(R.id.textView4));
        mLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        mLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mLayoutParams2.addRule(RelativeLayout.BELOW, mSpecialEditText.getId());

        mSpecialEditText.setText("HELLO, WORLD!");
        mSpecialEditText2.setText("HELLO, WORLD2!");

        mainRelativeLayout.addView(mSpecialEditText, mLayoutParams);
        //mainRelativeLayout.addView(mSpecialEditText2, mLayoutParams2);

        //mSpecialEditText.doStuff(SpecialEditText.POST_MODE);
        //mSpecialEditText2.doStuff(SpecialEditText.POST_MODE);

        Button b = (Button) findViewById(R.id.button);
        doPost(b);
    }

    public void doPost(View v) {
        final Button button = (Button) v;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("MainActivity","Anonymous Thread running");
                boolean success = mSpecialEditText.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("MainActivity","View's post's runnable running");
                        button.setText("SUCCESS");
                    }
                });
                Log.i("MainActivity", String.valueOf(success));
            }
        }).start();
    }


   // public void doPost(View view) {
  //      mSpecialEditText.doStuff(SpecialEditText.POST_MODE);
   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
