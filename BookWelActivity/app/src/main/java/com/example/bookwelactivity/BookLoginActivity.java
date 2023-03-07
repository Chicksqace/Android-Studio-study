package com.example.bookwelactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BookLoginActivity extends AppCompatActivity {
    private View btnLogin;
    private EditText edtUser,edtPass;
    Handler handler = new Handler()
    {
         public void handleMessage(Message msg) { super.handleMessage(msg);
             super.handleMessage(msg);
            if(msg.what==0) //编码为 0 触发
            {
                JSONObject jsonObject = (JSONObject)(msg.obj); //把相关的 obj 取出来转化成 JSONObject
                try {
                    String result = jsonObject.getString("result"); // 解析里面的 result 这个 key 的值
                    if(result.equals("ok")) //判断两个字符串是否相等用.equals，如果是 ok，登录成功跳转
                    {
                        Toast.makeText(BookLoginActivity.this,"登录成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookLoginActivity.this,BookMainActivity.class); startActivity(intent);
                    }else // 不是 ok 登录失败
                    {
                        Toast.makeText(BookLoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) { e.printStackTrace();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_login);
        btnLogin=findViewById(R.id.btn_login);
        edtUser=(EditText) findViewById(R.id.edt_user);
        edtPass=(EditText) findViewById(R.id.edt_pass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //引用 okhttp 类进行网络访问可以免除一些线程的操作
                MediaType JSON = MediaType.parse("application/json;charset=utf-8"); //这句话必不可少，表示媒体流是 json OkHttpClient client = new OkHttpClient(); // 创建一个 okhttp 客户端
                OkHttpClient client=new OkHttpClient();
                String json = "{\"username\":\""+edtUser.getText().toString()+"\",\"password\":\""+edtPass.getText().toString()+"\"}";
//{“username”:”book”, “password”:”5”}是对发包格式的拆分，其中 book 和 5 是替换成两个控件 edtUser 和
//                edtPass 读取 string 内容，其余内容由于双引号里面又有双引号，所以里面的所有双引号都加入转义字符\
                RequestBody body = RequestBody.create(JSON,json);//利用 JSON 媒体流说明和具体的 json 字符串生成包体
                Request request = new Request.Builder().url("http://study.smartye.top/api/shop/login").post(body).build();
//执行 post 请求
                Call call = client.newCall(request);//创建请求
//这是一个回调函数代码，call 的队列请求，这里隐含了线程，所以不需要自己创建线程
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//在回应中书写代码，读取回调函数参数 response 的 body 里面的 string 得到回复的字符串
                        String strJson = response.body().string();
                        try {
                            JSONObject jsonObject = new JSONObject(strJson);
                            handler.obtainMessage(0,jsonObject).sendToTarget();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}