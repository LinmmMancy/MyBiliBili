package com.mancy.mybilibili;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class LiveFragment extends BaseFragment {
    private TextView textView;

    @Override
    public View initView() {

        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);

      //  View view = View.inflate(context,R.layout.fragemngt_live,null);


        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("直播");
    }
}
