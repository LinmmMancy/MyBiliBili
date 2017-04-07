package com.mancy.mybilibili.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragments;
    private final List<String> mTitles;
    private String[] titles = new String[]{"直播", "推荐", "追番", "分区", "发现"};


    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }




    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];

    }
}
