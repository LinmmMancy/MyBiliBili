package com.mancy.mybilibili;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.mancy.mybilibili.ZhuiAdapter.ZhuiAdapter;
import com.mancy.mybilibili.bean.RunPlayBean;
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
public class ZhuiFanFragment extends BaseFragment {

    @InjectView(R.id.rv_home)
    RecyclerView rvHome;

    private ZhuiAdapter adapter;

    private RunPlayBean datas;


    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_zhui, null);

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
                .url("http://bangumi.bilibili.com/api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError:  失败 " + e.getMessage());


                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse11111111111111111:  联网成功" + response);
                        processData(response);
                    }
                });


    }


    private void processData(String json) {
        RunPlayBean bean = new Gson().fromJson(json, RunPlayBean.class);


        datas = bean;
        adapter = new ZhuiAdapter(context, datas);

        rvHome.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(context, 1);
        rvHome.setLayoutManager(manager);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
