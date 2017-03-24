package com.mancy.mybilibili;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mancy.mybilibili.TuiJian.TuiJianAdapter;
import com.mancy.mybilibili.bean.DirecTvInfo;
import com.mancy.mybilibili.gridrView.MyGridView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class TuijianFragment extends BaseFragment {
    @InjectView(R.id.tv_more_hot)
    TextView tvMoreHot;
    @InjectView(R.id.gv_hot)
    MyGridView gvHot;
    @InjectView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;
    private DirecTvInfo.DataBean data;
    TuiJianAdapter adapter;
    private TextView textView;

    @Override
    public View initView() {
//
        View view = View.inflate(context, R.layout.fragment_tuijian_item, null);
        ButterKnife.inject(this, view);
//        textView = new TextView(context);
//        textView.setTextSize(30);
//        textView.setGravity(Gravity.CENTER);
//
//        textView.setTextColor(Color.RED);

        return view;

    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();

        swiperefreshlayout.setDistanceToTriggerSync(100);
        swiperefreshlayout.setColorSchemeColors(Color.parseColor("#FB7299"));
        swiperefreshlayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromNet();
            }
        });

    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .url("http://live.bilibili.com/AppNewIndex/common?_device=android&appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&scale=hdpi&ts=1490013188000&sign=92541a11ed62841120e786e637b9db3b")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError:  失败 " + e.getMessage());


                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse:  联网成功" + response);
                        processData(response);
                        swiperefreshlayout.setRefreshing(false);
                    }
                });


    }


    private void processData(String json) {
        DirecTvInfo direcTvInfo = new Gson().fromJson(json, DirecTvInfo.class);
        data = direcTvInfo.getData();


        adapter = new TuiJianAdapter(context, data);
        gvHot.setAdapter(adapter);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }
}
