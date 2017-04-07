package com.mancy.mybilibili.Fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.Adapter.FanJusAdapter;
import com.mancy.mybilibili.bean.FanJuBean;
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

public class SomeDramaFragment extends BaseFragment {
    @InjectView(R.id.rl_recycler)
    RecyclerView rlRecycler;
    private TextView textView;
    private FanJuBean fanJuBean;
    private FanJusAdapter adapter;

    @Override
    public View initView() {

        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);
        View view = View.inflate(context, R.layout.fragment_faxian_fanju, null);
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
                .url("http://app.bilibili.com/x/v2/rank?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&order=bangumi&platform=android&pn=1&ps=20&ts=1490015891000&sign=c29299ef4b95c26e104efc13437cf628")
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
        fanJuBean = new Gson().fromJson(json, FanJuBean.class);
        FanJuBean datas = fanJuBean;

        adapter = new FanJusAdapter(context,datas );

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
