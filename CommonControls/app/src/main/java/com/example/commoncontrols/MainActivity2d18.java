package com.example.commoncontrols;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2d18 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d18);
        Button btn =(Button) findViewById(R.id.btn_dialog2);
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Login");
                LayoutInflater inflater=LayoutInflater.from(MainActivity2d18.this);
                View view1=inflater.inflate(R.layout.activity_main,null);
                builder.setView(view1);
                final EditText editUserName=(EditText) view1.findViewById(R.id.edit_username);
                final EditText editPassword=(EditText) view1.findViewById(R.id.edit_password);
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username=editUserName.getText().toString();
                        String password=editPassword.getText().toString();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2d18.this,"press Cancel ",Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
            }
        });


    }
}