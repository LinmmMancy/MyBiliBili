package com.mancy.mybilibili;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    //    @InjectView(R.id.fl_main)
//    FrameLayout flMain;
    @InjectView(R.id.navigation_view)
    NavigationView navigationView;
    @InjectView(R.id.id_drawer_layout)
    DrawerLayout idDrawerLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;


    private ArrayList<Fragment> fragment;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#FB7299"));


        initData();
    }

    private void initData() {


        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.tab_title_main_1));
        titles.add(getString(R.string.tab_title_main_2));
        titles.add(getString(R.string.tab_title_main_3));
        tablayout.addTab(tablayout.newTab().setText(titles.get(0)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(1)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(2)));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LiveFragment());
        fragments.add(new TuijianFragment());
        fragments.add(new ZhuiFanFragment());
        fragments.add(new FenFragment());
        fragments.add(new FaxainFragment());

        viewPager.setOffscreenPageLimit(2);

        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(mFragmentAdapter);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(mFragmentAdapter);
    }

}