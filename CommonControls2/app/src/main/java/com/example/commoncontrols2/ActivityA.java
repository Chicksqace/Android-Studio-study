package com.example.commoncontrols2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        initWidget();
        Intent intent=getIntent();
    }

    private void initWidget() {
        Button btn=(Button) findViewById(R.id.btn_click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityA.this,ActivityB.class);
                intent.putExtra("key","数据急急急急急急军军");
                startActivity(intent);
            }
        });
    }
}