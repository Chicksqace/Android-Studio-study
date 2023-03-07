package com.example.commoncontrols2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initWidget();
    }

    private void initWidget() {
        Button btn=(Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity1.this,LoginActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.e("result","requestCode"+requestCode+"resultCode"+resultCode+"data"+data);
        if(1!=requestCode || RESULT_OK!=resultCode||null==data){
            return;
        }
        String strUsername=data.getStringExtra("username");
        String strUserpassword=data.getStringExtra("password");
        showResult(strUsername,strUserpassword);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showResult(String username,String password) {
        Button btn=(Button) findViewById(R.id.btn_login);
        btn.setVisibility(View.GONE);
        LinearLayout lly=(LinearLayout) findViewById(R.id.user_info);
        lly.setVisibility(View.VISIBLE);

        TextView txtUsername=(TextView) findViewById(R.id.txt_username);
        TextView txtPassword=(TextView) findViewById(R.id.txt_password);
        txtUsername.setText("用户输入的用户名是"+username);
        txtPassword.setText("用户输入的密码是"+password);

    }
}