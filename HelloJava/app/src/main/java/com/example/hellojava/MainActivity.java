package com.example.hellojava;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ConstraintLayout mainLayout;
    Button btnOrientation;

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() invoked");

        //refer to layout
        mainLayout = findViewById(R.id.mainLayout);
        //refer to the button
        btnOrientation = findViewById(R.id.btnOrientation);
        btnOrientation.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart() invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() invoked");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        /** This method will be invoked whenever
         * any configuration changes */

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.d(TAG, "Landscape Orientation");
            mainLayout.setBackgroundColor(Color.CYAN);
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.d(TAG, "Portrait Orientation");
            mainLayout.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnOrientation.getId()){

            //detect the current orientation
            //return 1 (portrait) or 2 (Landscape)
            int orientation = this.getResources().getConfiguration().orientation;


            if (orientation == Configuration.ORIENTATION_PORTRAIT){
                //changing orientation
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        }
    }
}
