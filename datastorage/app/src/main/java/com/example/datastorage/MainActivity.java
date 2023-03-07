package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String FILE_NAME="hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_one();
    }

    private void init_one() {
        Button btnWrite = (Button) findViewById(R.id.btn_write);
        Button btnRend = (Button) findViewById(R.id.btn_rend);
        final TextView textView = (TextView) findViewById(R.id.txt_info);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = new Random().nextInt();
                write(value);
            }


        });
        btnRend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = read();
                textView.setText("The Number Is" + value);
            }
        });
    }
        private void write(int value) {
            try {
                FileOutputStream fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
                fos.write(String.valueOf(value).getBytes(StandardCharsets.UTF_8));
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        private int read() {
            try {
                FileInputStream fis=openFileInput(FILE_NAME);
                DataInputStream dis=new DataInputStream(fis);
                int value=dis.readInt();
                dis.close();
                fis.close();
                return value;
            } catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }
    }


