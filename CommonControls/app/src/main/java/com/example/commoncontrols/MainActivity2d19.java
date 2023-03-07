package com.example.commoncontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity2d19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d19);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
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
                return super.onOptionsItemSelected(item);
        }
    }
}