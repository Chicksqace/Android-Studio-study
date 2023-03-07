package com.example.commoncontrols;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity2d20 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d20);
        TextView txt=(TextView) findViewById(R.id.long_click);
        registerForContextMenu1(txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("1111111");
            }
        });
    }
    public void registerForContextMenu1(View view) {
        view.setOnCreateContextMenuListener(this);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
            {
                Log.i("Menu","menu add");
                return true;
            }
            case R.id.menu_delete:
            {
                Log.i("Menu","menu delete");
                return true;
            }
            case R.id.menu_query:
            {
                Log.i("Menu","menu query");
                return true;
            }
            case R.id.menu_exit:
            {
                Log.i("Menu","menu exit");
                return true;
            }
            default:
                return super.onContextItemSelected(item);
        }
    }
}