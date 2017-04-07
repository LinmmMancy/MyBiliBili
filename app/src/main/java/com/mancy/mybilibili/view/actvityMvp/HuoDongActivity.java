package com.mancy.mybilibili.view.actvityMvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.HuoDongBean;
import com.mancy.mybilibili.Presenter.HuodongPrsenter;
import com.mancy.mybilibili.Adapter.HuodongAdapter;
import com.mancy.mybilibili.view.HuodongView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HuoDongActivity extends AppCompatActivity implements HuodongView {


    RelativeLayout activityHuoDong;
    @InjectView(R.id.lv_listview)
    ListView lvListview;
    @InjectView(R.id.activity_topic_center)
    LinearLayout activityTopicCenter;
    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tv_title_text)
    TextView tvTitleText;
    private List<HuoDongBean.ListBean> datas;
    private HuodongAdapter adapter;


    private HuodongPrsenter huodongPrsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_dong);
        ButterKnife.inject(this);
        huodongPrsenter = new HuodongPrsenter(this);

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
        tvTitleText.setText("活动中心");
    }

    private void initData() {
        huodongPrsenter.getDataFromNet("http://api.bilibili.com/event/");
    }

    @Override
    public void onsuccess(HuoDongBean huoDongBean) {
        datas = huoDongBean.getList();
        adapter = new HuodongAdapter(this, datas);
        lvListview.setAdapter(adapter);
    }

    @Override
    public void showFailedError(Exception e) {

    }
}
