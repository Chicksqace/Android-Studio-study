package com.example.commoncontrols2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Intent intent=getIntent();
        String strValue=intent.getStringExtra("key");
        TextView txtView=(TextView) findViewById(R.id.txt_content);
        txtView.setText(strValue);
        go();
    }

    private void go() {
        Button btn=(Button) findViewById(R.id.btn_click1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityB.this,ActivityA.class);
                startActivity(intent);
            }
        });
    }
}