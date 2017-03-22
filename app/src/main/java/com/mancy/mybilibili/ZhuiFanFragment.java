package com.mancy.mybilibili;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mancy.mybilibili.ZhuiFan.ZhuiFanAdapter;
import com.mancy.mybilibili.ZhuiFan.ZhuiFanAdapter2;
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

    @InjectView(R.id.imageView3)
    ImageView imageView3;
    @InjectView(R.id.imageView4)
    ImageView imageView4;
    @InjectView(R.id.textView4)
    TextView textView4;
    @InjectView(R.id.ll_more_play)
    LinearLayout llMorePlay;
    @InjectView(R.id.gv_play)
    GridView gvPlay;
    @InjectView(R.id.gv_play2)
    GridView gvPlay2;

    private ZhuiFanAdapter adapter;
    private ZhuiFanAdapter2 adapter2;


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
        adapter = new ZhuiFanAdapter(context, datas);
        adapter2 = new ZhuiFanAdapter2(context, datas);

        gvPlay.setAdapter(adapter);
        gvPlay2.setAdapter(adapter2);

        gvPlay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "positon" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
