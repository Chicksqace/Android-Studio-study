package com.example.commoncontrols2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initWidget();
    }

    private void initWidget() {
        Button btn=(Button) findViewById(R.id.btn_commit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editUserName=(EditText) findViewById(R.id.edit_username);
                EditText editPassword=(EditText) findViewById(R.id.edit_password);
                Intent data=new Intent();
                data.putExtra("username",editUserName.getText().toString());
                data.putExtra("password",editPassword.getText().toString());
                setResult(RESULT_OK,data);
                LoginActivity.this.finish();
            }
        });
    }
}