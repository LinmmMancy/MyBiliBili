package com.mancy.mybilibili;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.mancy.mybilibili.Find.TopicAdapter;
import com.mancy.mybilibili.bean.ToppicBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

public class TopicCenterActivity extends AppCompatActivity {

    @InjectView(R.id.lv_listview)
    ListView lvListview;
    @InjectView(R.id.activity_topic_center)
    LinearLayout activityTopicCenter;


    private ToppicBean toppicBean;

    private TopicAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_center);
        ButterKnife.inject(this);
        initData();
    }


    private void initData() {
        getDataFromNet();

    }

    private void getDataFromNet() {

        OkHttpUtils.get()
                .url("http://api.bilibili.com/topic/getlist?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&page=1&pageSize=20&platform=android&ts=1490015740000&sign=be68382cdc99c168ef87f2fa423dd280")
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
        toppicBean = new Gson().fromJson(json, ToppicBean.class);
        final List<ToppicBean.ListBean> datas = toppicBean.getList();


        adapter = new TopicAdapter(this, datas);

        lvListview.setAdapter(adapter);




    }
}
