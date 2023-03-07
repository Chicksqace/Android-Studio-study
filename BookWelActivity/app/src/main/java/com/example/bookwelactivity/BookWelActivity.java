package com.example.bookwelactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class BookWelActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments=new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_wel);
        viewPager =(ViewPager) findViewById(R.id.view_pager);
        fragments.add(new BookFrag1());
        fragments.add(new BookFrag2());
        BookAdapter bookAdapter=new BookAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(bookAdapter);

    }
}