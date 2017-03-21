package com.mancy.mybilibili;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mancy.mybilibili.LiveAdapter.LiveAdapter;
import com.mancy.mybilibili.bean.DirecTvInfo;
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
public class LiveFragment extends BaseFragment {
    @InjectView(R.id.rv_home)
    RecyclerView rvHome;

    private TextView textView;
    private DirecTvInfo.DataBean datas;

    private LiveAdapter adapter;

    @Override
    public View initView() {


        View view = View.inflate(context, R.layout.fragemngt_live, null);
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
                        Log.e("TAG", "onResponse:  联网成功");
                        processData(response);
                    }
                });

    }

    private void processData(String json) {
        DirecTvInfo direcTvInfo = new Gson().fromJson(json, DirecTvInfo.class);
        datas = direcTvInfo.getData();
        adapter = new LiveAdapter(context, datas);


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
