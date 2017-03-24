package com.mancy.mybilibili.faxian.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mancy.mybilibili.BaseFragment;

import java.util.List;

/**
 * Created by linmingming(林明明) on 2017/3/24.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class HDFragmentAdapter extends FragmentStatePagerAdapter {
    private final List<BaseFragment> fragments;
    private final List<String> titles;

    private String[] mtitles = new String[]{"原创", "全站", "番剧"};


    public HDFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles[position];

    }
}
