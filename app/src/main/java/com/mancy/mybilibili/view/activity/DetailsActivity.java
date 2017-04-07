package com.mancy.mybilibili.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mancy.mybilibili.Fragment.BaseFragment;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.Adapter.DetailsAdapter;
import com.mancy.mybilibili.Fragment.JianjieFragment;
import com.mancy.mybilibili.Fragment.PingLunFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailsActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.iv_image)
    ImageView ivImage;
    @InjectView(R.id.t1)
    CollapsingToolbarLayout t1;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.cl_main)
    CoordinatorLayout clMain;
    @InjectView(R.id.id_drawer_layout)
    FrameLayout idDrawerLayout;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    private DetailsAdapter detailsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        initDta();

    }

    private void initDta() {

        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.tab_title_main_1));
        titles.add(getString(R.string.tab_title_main_2));
        titles.add(getString(R.string.tab_title_main_3));
        tablayout.addTab(tablayout.newTab().setText(titles.get(0)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(1)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(2)));
        List<BaseFragment> fragments = new ArrayList<>();

        fragments.add(new JianjieFragment());
        fragments.add(new PingLunFragment());

        viewPager.setOffscreenPageLimit(2);


        detailsAdapter = new DetailsAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(detailsAdapter);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(detailsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_xianqing, menu);
        return true;

    }

}
