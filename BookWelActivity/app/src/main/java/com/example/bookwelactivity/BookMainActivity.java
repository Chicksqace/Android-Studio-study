package com.example.bookwelactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
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

public class BookMainActivity extends AppCompatActivity {
    private ListView listView;
    Handler handler = new Handler()
    {
        public void handleMessage(Message msg) { super.handleMessage(msg);
            super.handleMessage(msg);
            if(msg.what==0){
                JSONArray jsonArray=(JSONArray) (msg.obj);
                MyAdapter adapter=new MyAdapter(BookMainActivity.this,jsonArray);
                listView.setAdapter(adapter);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_main);
        listView =(ListView) findViewById(R.id.list_view);

            //引用 okhttp 类进行网络访问可以免除一些线程的操作
            OkHttpClient client=new OkHttpClient();

            Request request = new Request.Builder().url("http://study.smartye.top/api/shop/book").get().build();
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
                    String strArray = response.body().string();
                    try {
                        JSONArray jsonArray = new JSONArray(strArray);
                        handler.obtainMessage(0,jsonArray).sendToTarget();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    private static class MyAdapter extends BaseAdapter{
        private Context context;
        private JSONArray jsonArray;
        public MyAdapter(Context context,JSONArray jsonArray){
            this.context=context;
            this.jsonArray=jsonArray;
        }
        @Override
        public int getCount() {
            return jsonArray.length();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater=LayoutInflater.from(this.context);

            view=inflater.inflate(R.layout.book_item,null);
            TextView tvName = (TextView) view.findViewById(R.id.name);
            TextView tvPrice = (TextView) view.findViewById(R.id.price);
            TextView tvWriter = (TextView) view.findViewById(R.id.write);
            try {
                tvName.setText(jsonArray.getJSONObject(i).getString("book_name"));
                tvPrice.setText(jsonArray.getJSONObject(i).getString("book_price")+"元");
                tvWriter.setText(jsonArray.getJSONObject(i).getString("writer"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}