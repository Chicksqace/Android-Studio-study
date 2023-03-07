package com.example.commoncontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity2d14 extends AppCompatActivity {
private int progress=0;
private ProgressBar progressBar;
private Handler mHandler=new Handler();
private Runnable task=new Runnable() {
    @Override
    public void run() {
        ++progress;
        progressBar.setProgress(progress);
        if(progress>=100){
            mHandler.removeCallbacks(this);
        }else{
            mHandler.postDelayed(this,1000);
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d14);
        progressBar=(ProgressBar) findViewById(R.id.progress);
        mHandler.postDelayed(task,1000);
    }
}