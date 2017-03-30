package com.mancy.mybilibili;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.Downlist.DownloadListActivity;
import com.mancy.mybilibili.FenQuAdapter.FenFragment;
import com.mancy.mybilibili.LiveAdapter.LiveFragment;
import com.mancy.mybilibili.LoginActivity.LoginActivity;
import com.mancy.mybilibili.TuiJian.TuijianFragment;
import com.mancy.mybilibili.ZhuiFan.ZhuiFanFragment;
import com.mancy.mybilibili.faxian.fragment.FaxainFragment;
import com.mancy.mybilibili.utils.CircleImageView;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    @InjectView(R.id.chuaxianLeft)
    ImageView chuaxianLeft;
    @InjectView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.cl_main)
    CoordinatorLayout clMain;
    @InjectView(R.id.navigation_view)
    NavigationView navigationView;

    @InjectView(R.id.id_drawer_layout)
    DrawerLayout idDrawerLayout;
    @InjectView(R.id.iv_image)
    CircleImageView ivImage;


    private ArrayList<Fragment> fragment;
    private FloatingActionButton fab;
    private SearchFragment searchFragment;
    private ImageView iviv;

    private Integer[] mThumbIds = {
            R.drawable.bangumi_home_index_jp_ic,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        View heardView = navigationView.inflateHeaderView(R.layout.left_header);
        iviv = (ImageView) heardView.findViewById(R.id.iv_iv);
        Glide.with(this).load(mThumbIds[0]).bitmapTransform(
                new CropCircleTransformation(this)).crossFade(1000).into(iviv);

        iviv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });


        initData();
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        searchFragment = SearchFragment.newInstance();
                        searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                            @Override
                            public void OnSearchClick(String keyword) {
//                                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
//                                ToastUtil.showSuccessMsg("lalallala ");
                                startActivity(new Intent(MainActivity.this, SearchActivity.class));


                            }
                        });
                        searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);

                        break;

                    case R.id.action_settings:
                        startActivity(new Intent(MainActivity.this, DownloadListActivity.class));
                        break;


                }
                return true;
            }
        });


        navigationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    private void initData() {


        Glide.with(this).load(mThumbIds[0]).bitmapTransform(
                new CropCircleTransformation(this)).crossFade(1000).into(ivImage);


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

        viewPager.setOffscreenPageLimit(fragments.size());

        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(mFragmentAdapter);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(mFragmentAdapter);


    }

}