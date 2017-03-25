package com.mancy.mybilibili.TuiJian;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mancy.mybilibili.BaseFragment;
import com.mancy.mybilibili.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/25.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class JianjieFragment extends BaseFragment {
    @InjectView(R.id.rl_recycler)
    RecyclerView rlRecycler;
    private TextView textView;

    @Override
    public View initView() {

        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);
        View view = View.inflate(context, R.layout.fragment_jianjie_view, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        textView.setText("原创");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
