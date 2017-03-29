package com.mancy.mybilibili.faxian.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mancy.mybilibili.BaseFragment;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.faxian.adpter.ShopHomeadapter;
import com.mancy.mybilibili.faxian.bean.ShopHomeBean;
import com.mancy.mybilibili.gridrView.MyGridView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by linmingming(林明明) on 2017/3/28.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class ShopHomeFragment extends BaseFragment {
    public static final String IMAGES = "images";
    public static final String TITLE = "title";
    public static final String JIAGE = "jiage";
    public static final String ID = "id";
    @InjectView(R.id.gv_hot)
    MyGridView gvHot;
    private TextView textView;

    private ShopHomeadapter adapter;
    private ShopHomeBean.ResultBean shopdata;

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);

        textView.setTextColor(Color.RED);

        View view = View.inflate(context, R.layout.fragment_shophome, null);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
        Log.e("TAG", "我是分类");

//        textView.setText("首页");


    }

    private void getDataFromNet() {

        OkHttpUtils.get()
                .url("http://bmall.bilibili.com/api/product/list.do?pn=1&ps=6")
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
//                        swiperefreshlayout.setRefreshing(false);

                    }
                });


    }


    private void processData(String json) {

        ShopHomeBean shopHomeBean = new Gson().fromJson(json, ShopHomeBean.class);

        shopdata = shopHomeBean.getResult();


        GridLayoutManager manager = new GridLayoutManager(context, 1);
        adapter = new ShopHomeadapter(context, shopdata);
        gvHot.setAdapter(adapter);
        gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "" + shopdata.getRecords().get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ShopInfoActivity.class);
                intent.putExtra(IMAGES, shopdata.getRecords().get(position).getImgUrl());
                intent.putExtra(TITLE, shopdata.getRecords().get(position).getTitle());
                intent.putExtra(JIAGE, shopdata.getRecords().get(position).getSalvePrice()+"");
                intent.putExtra(ID, shopdata.getRecords().get(position).getSkuId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
