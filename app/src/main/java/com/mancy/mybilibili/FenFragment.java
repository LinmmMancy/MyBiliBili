package com.mancy.mybilibili;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mancy.mybilibili.FenQuAdapter.FenQuAdapter;
import com.mancy.mybilibili.bean.FenQuBean;
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
public class FenFragment extends BaseFragment {


    @InjectView(R.id.gv_partion)
    GridView gvPartion;

    @InjectView(R.id.title_pic)
    ImageView titlePic;
    @InjectView(R.id.titles)
    TextView titles;
    @InjectView(R.id.tv_more_hot)
    TextView tvMoreHot;
    @InjectView(R.id.gv_hot)
    MyGridView gvHot;
    @InjectView(R.id.textView8)
    TextView textView8;
    private ItemAdapter itemAdapter;

    private FenQuBean datas;
    private FenQuAdapter adapter;


    //partition

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_fen, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        itemAdapter = new ItemAdapter(context);
        gvPartion.setAdapter(itemAdapter);

        getDataFromNet();
    }

    private void getDataFromNet() {

        OkHttpUtils.get()
                .url("http://app.bilibili.com/x/v2/show/region?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&ts=1490014674000&sign=93edb7634f38498a60e5c3ad0b8b0974")
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
        FenQuBean fenQuBean = new Gson().fromJson(json, FenQuBean.class);
        datas = fenQuBean;
        adapter = new FenQuAdapter(context, datas);
        gvHot.setAdapter(adapter);
        gvHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "posotion" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
