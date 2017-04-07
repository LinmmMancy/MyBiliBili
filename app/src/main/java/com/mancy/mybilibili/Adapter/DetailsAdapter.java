package com.mancy.mybilibili.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mancy.mybilibili.Fragment.BaseFragment;

import java.util.List;

/**
 * Created by linmingming(林明明) on 2017/3/25.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class DetailsAdapter extends FragmentStatePagerAdapter {


    private final List<String> mTitles;
    private final List<BaseFragment> mFragments;
    private String[] titles = new String[]{"简介", "评论"};


    public DetailsAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
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