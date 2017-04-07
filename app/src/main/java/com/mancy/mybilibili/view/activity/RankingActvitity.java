package com.mancy.mybilibili.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mancy.mybilibili.Fragment.BaseFragment;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.Adapter.HDFragmentAdapter;
import com.mancy.mybilibili.view.fragment.OriginalFragment;
import com.mancy.mybilibili.Fragment.SomeDramaFragment;
import com.mancy.mybilibili.Fragment.TotalStationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RankingActvitity extends AppCompatActivity {


    @InjectView(R.id.back)
    ImageView back;
    @InjectView(R.id.iv_sousuo)
    ImageView ivSousuo;
    @InjectView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    @InjectView(R.id.cl_main)
    CoordinatorLayout clMain;
    @InjectView(R.id.navigation_view)
    NavigationView navigationView;
    @InjectView(R.id.id_drawer_layout)
    DrawerLayout idDrawerLayout;
    private HDFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_actvitity);
        ButterKnife.inject(this);
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {

        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.tab_title_main_1));
        titles.add(getString(R.string.tab_title_main_2));
        titles.add(getString(R.string.tab_title_main_3));
        tablayout.addTab(tablayout.newTab().setText(titles.get(0)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(1)));
        tablayout.addTab(tablayout.newTab().setText(titles.get(2)));

        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new OriginalFragment());
        fragments.add(new TotalStationFragment());
        fragments.add(new SomeDramaFragment());

        adapter = new HDFragmentAdapter(getSupportFragmentManager(), fragments, titles);

        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(RankingActvitity.this, FaxainFragment.class);
//
//                startActivity(intent);
                finish();
            }
        });


    }
}
