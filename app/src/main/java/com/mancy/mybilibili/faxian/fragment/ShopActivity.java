package com.mancy.mybilibili.faxian.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mancy.mybilibili.R;
import com.mancy.mybilibili.faxian.adpter.ShopAdapter;
import com.youth.banner.Banner;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShopActivity extends AppCompatActivity {


    @InjectView(R.id.banner)
    Banner banner;
    private ShopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.inject(this);

        initListener();

        initData();
    }

    private void initData() {

    }



    private void initListener() {


    }
}
