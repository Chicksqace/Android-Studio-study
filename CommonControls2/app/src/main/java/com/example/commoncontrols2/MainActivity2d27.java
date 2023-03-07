package com.example.commoncontrols2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2d27 extends AppCompatActivity {
    private final int MSG_ID=1001;
    private TextView txt;
    private MyHandler mHandler=new MyHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d27);
        txt=(TextView) findViewById(R.id.txt);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int num=new Random().nextInt(1000);
                Message msg=new Message();
                msg.what=MSG_ID;
                msg.obj=num;
                mHandler.sendMessage(msg);
            }
        },1000,1000);
    }

    private class MyHandler extends Handler {
        public void handleMessage(Message msg){
            switch (msg.what){
                case MSG_ID:
                {
                    int num=(Integer)msg.obj;
                    txt.setText("The num is"+num);
                    break;
                }
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }
}