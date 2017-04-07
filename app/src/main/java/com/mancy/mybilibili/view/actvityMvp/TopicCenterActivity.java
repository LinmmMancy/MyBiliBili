package com.mancy.mybilibili.view.actvityMvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mancy.mybilibili.Adapter.TopicAdapter;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.ToppicBean;
import com.mancy.mybilibili.Presenter.TopicPrsenter;
import com.mancy.mybilibili.view.TopicView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TopicCenterActivity extends AppCompatActivity implements TopicView {

    @InjectView(R.id.lv_listview)
    ListView lvListview;
    @InjectView(R.id.activity_topic_center)
    LinearLayout activityTopicCenter;
    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tv_title_text)
    TextView tvTitleText;


    private ToppicBean toppicBean;

    private TopicAdapter adapter;

    private TopicPrsenter prsenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_center);
        ButterKnife.inject(this);
        prsenter = new TopicPrsenter(this);
        initData();
        initListener();
    }

    private void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitleText.setText("话题中心");
    }


    private void initData() {
        prsenter.getDataFromNet("http://api.bilibili.com/topic/");

    }


    @Override
    public void onSuccess(ToppicBean toppicBean) {

         List<ToppicBean.ListBean> datas = toppicBean.getList();
//
//
        adapter = new TopicAdapter(this, datas);
//
        lvListview.setAdapter(adapter);
    }
}
