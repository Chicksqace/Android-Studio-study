package com.example.commoncontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2d11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d11);
        initWidget();

    }

    private void initWidget() {
        Button btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt=(TextView) findViewById(R.id.txt);
                String str=txt.getText().toString();
                txt.setText("Hello".equals(str)?"World":"Hello");
            }
        });
    }
}