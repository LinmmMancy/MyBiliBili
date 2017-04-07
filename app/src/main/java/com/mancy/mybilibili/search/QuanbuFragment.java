package com.mancy.mybilibili.search;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mancy.mybilibili.Fragment.BaseFragment;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.gridrView.MyListView;
import com.mancy.mybilibili.search.adapter.ZongheAdapter;
import com.mancy.mybilibili.search.bean.ZongheBean;
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

public class QuanbuFragment extends BaseFragment {
    @InjectView(R.id.My_listview)
    MyListView MyListview;
    private TextView textView;
    private ZongheBean zongheBean;
    private ZongheBean.DataBean.ItemsBean zonghedata;

    private ZongheAdapter adapter;

    @Override
    public View initView() {

        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);

        View view = View.inflate(context, R.layout.fragment_quanbu_view, null);
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
                .url("http://app.bilibili.com/x/v2/search?appkey=1d8b6e7d45233436&build=501000&duration=0&keyword=%E6%9E%81%E4%B9%90%E5%87%80%E5%9C%9F&mobi_app=android&platform=android&pn=1&ps=20")
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
        zongheBean = new Gson().fromJson(json, ZongheBean.class);
        zonghedata = zongheBean.getData().getItems();

        adapter = new ZongheAdapter(context, zonghedata);

        MyListview.setAdapter(adapter);
        MyListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "" + zonghedata.getArchive().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
