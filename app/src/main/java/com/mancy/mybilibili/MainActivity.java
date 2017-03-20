package com.mancy.mybilibili;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("  小明哥");
        toolbar.setLogo(R.drawable.ic_noface);// tou、
        toolbar.setTitleTextColor(Color.YELLOW);
        toolbar.setBackgroundColor(Color.parseColor("#FB7299"));

    }


}