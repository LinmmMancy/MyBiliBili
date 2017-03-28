package com.mancy.mybilibili.faxian.fragment;


import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mancy.mybilibili.BaseFragment;
import com.mancy.mybilibili.R;

/**
 * Created by linmingming(林明明) on 2017/3/28.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class ShopCarFragment extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);

        View view = View.inflate(context, R.layout.activity_shopping_acativity, null);

        return view;
    }

    @Override
    public void initData() {
        super.initData();

        Log.e("TAG", "我是分类");

        textView.setText("购物车");
    }
}
