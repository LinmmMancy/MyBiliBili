package com.mancy.mybilibili.faxian.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mancy.mybilibili.BaseFragment;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.faxian.adpter.OriginalsAdapter;
import com.mancy.mybilibili.faxian.bean.OriginalBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by linmingming(林明明) on 2017/3/24.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class OriginalFragment extends BaseFragment {

    @InjectView(R.id.rl_recycler)
    RecyclerView rlRecycler;
    private TextView textView;
    private OriginalBean originalBean;

    private OriginalsAdapter adapter;


    @Override
    public View initView() {

//        textView = new TextView(context);
//        textView.setTextSize(30);
//        textView.setGravity(Gravity.CENTER);
//
//        textView.setTextColor(Color.RED);

        View view = View.inflate(context, R.layout.fragment_faxian_original, null);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();

    }


    private void getDataFromNet() {

        OkHttpUtils.get()
                .url("http://app.bilibili.com/x/v2/rank?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&order=origin&platform=android&pn=1&ps=20&ts=1490015891000&sign=1a5a1c73e3b23be37fb13ee0178ceef0")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError:  失败 " + e.getMessage());


                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse:  联网成功");
                        processData(response);
                    }
                });


    }


    private void processData(String json) {
        originalBean = new Gson().fromJson(json, OriginalBean.class);
        OriginalBean data = originalBean;

        adapter = new OriginalsAdapter(context, data);

        rlRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        rlRecycler.setLayoutManager(linearLayoutManager);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
