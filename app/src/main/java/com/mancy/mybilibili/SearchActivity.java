package com.mancy.mybilibili;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mancy.mybilibili.faxian.fragment.TotalStationFragment;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchActivity extends AppCompatActivity {


    @InjectView(R.id.iv_search_back)
    ImageView ivSearchBack;
    @InjectView(R.id.et_search_keyword)
    EditText etSearchKeyword;
    @InjectView(R.id.iv_search_search)
    ImageView ivSearchSearch;
    @InjectView(R.id.ll_layout)
    LinearLayout llLayout;
    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.inject(this);

        SearchFragment searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
            @Override
            public void OnSearchClick(String keyword) {
                Toast.makeText(SearchActivity.this, "1", Toast.LENGTH_SHORT).show();


            }
        });
        searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
        initListener();
        initData();
    }

    private void initListener() {
        ivSearchSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        etSearchKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = SearchFragment.newInstance();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        //Toast.makeText(SearchActivity.this, "1", Toast.LENGTH_SHORT).show();


                    }
                });
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
            }
        });
        ivSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
        fragments.add(new TotalStationFragment());
        fragments.add(new TotalStationFragment());
        fragments.add(new TotalStationFragment());
        fragments.add(new TotalStationFragment());
        fragments.add(new TotalStationFragment());

        viewPager.setOffscreenPageLimit(fragments.size());

        FragmentAdapters mFragmentAdapter = new FragmentAdapters(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(mFragmentAdapter);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabsFromPagerAdapter(mFragmentAdapter);


    }

}
