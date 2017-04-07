package com.mancy.mybilibili.Fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.mancy.mybilibili.Adapter.TuiJianAdapter;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.TuiJianBean;
import com.mancy.mybilibili.gridrView.MyGridView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

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
    TuiJianAdapter adapter;
    private TextView textView;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_tuijian_item, null);
        ButterKnife.inject(this, view);
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
                .url("http://app.bilibili.com/x/feed/index?appkey=1d8b6e7d45233436&build=501000&idx=1490013261&mobi_app=android&network=wifi&platform=android&pull=true&style=2&ts=1490015599000&sign=af4edc66aef7e443c98c28de2b660aa4")
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
        TuiJianBean tuiJianBean = JSON.parseObject(json, TuiJianBean.class);
        List<TuiJianBean.DataBean> datas = tuiJianBean.getData();
        adapter = new TuiJianAdapter(context, datas);
        gvHot.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
