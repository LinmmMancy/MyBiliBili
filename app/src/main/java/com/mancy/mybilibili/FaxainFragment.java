package com.mancy.mybilibili;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mancy.mybilibili.bean.TagBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

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
public class FaxainFragment extends BaseFragment {
    @InjectView(R.id.search_scan)
    ImageView searchScan;
    @InjectView(R.id.search_edit)
    TextView searchEdit;
    @InjectView(R.id.search_img)
    ImageView searchImg;
    @InjectView(R.id.card_view)
    CardView cardView;
    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.tags_layout)
    TagFlowLayout tagsLayout;
    @InjectView(R.id.hide_tags_layout)
    TagFlowLayout hideTagsLayout;
    @InjectView(R.id.hide_scroll_view)
    NestedScrollView hideScrollView;
    @InjectView(R.id.tv_more)
    TextView tvMore;
    @InjectView(R.id.more_layout)
    LinearLayout moreLayout;
    @InjectView(R.id.ic_quanzi)
    ImageView icQuanzi;
    @InjectView(R.id.ic_quanzi_layout)
    RelativeLayout icQuanziLayout;
    @InjectView(R.id.ic_topic)
    ImageView icTopic;
    @InjectView(R.id.topic_center_layout)
    RelativeLayout topicCenterLayout;
    @InjectView(R.id.ic_activity)
    ImageView icActivity;
    @InjectView(R.id.activity_center_layout)
    RelativeLayout activityCenterLayout;
    @InjectView(R.id.ic_original)
    ImageView icOriginal;
    @InjectView(R.id.layout_original)
    RelativeLayout layoutOriginal;
    @InjectView(R.id.ic_all_rank)
    ImageView icAllRank;
    @InjectView(R.id.layout_all_rank)
    RelativeLayout layoutAllRank;
    @InjectView(R.id.ic_game)
    ImageView icGame;
    @InjectView(R.id.layout_game_center)
    RelativeLayout layoutGameCenter;
    @InjectView(R.id.ic_shop)
    ImageView icShop;
    @InjectView(R.id.layout_shop)
    RelativeLayout layoutShop;

    private List<TagBean.DataBean.ListBean> datas;

    private boolean isShowMore = true;

    @Override
    public View initView() {
        /**
         * http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&limit=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc
         */
//
//        textView = new TextView(context);
//        textView.setTextSize(30);
//        textView.setGravity(Gravity.CENTER);
//
//        textView.setTextColor(Color.RED);


        View view = View.inflate(context, R.layout.fragment_faxian, null);

        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //  textView.setText("发现");
        initListener();

        getTagNet();

    }

    private void getTagNet() {

        OkHttpUtils.get()
                .url("http://app.bilibili.com/x/v2/search/hot?appkey=1d8b6e7d45233436&build=501000&limit=50&mobi_app=android&platform=android&ts=1490014710000&sign=e5ddf94fa9a0d6876cb85756c37c4adc")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "onError: 联网失败" + e.getMessage());

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse: 联网成功" + response);
                        processData(response);
                    }
                });

    }

    private void processData(String response) {
        TagBean tagBean = new Gson().fromJson(response, TagBean.class);
        datas = tagBean.getData().getList();

        List<TagBean.DataBean.ListBean> listBeen = datas.subList(0, 8);

        tagsLayout.setAdapter(new TagAdapter<TagBean.DataBean.ListBean>(listBeen) {

            @Override
            public View getView(FlowLayout parent, final int position, final TagBean.DataBean.ListBean listBean) {
                TextView tags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.layout_tags_item, parent, false);
                tags.setText(listBean.getKeyword());
                tags.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "position" + listBean.getKeyword(), Toast.LENGTH_SHORT).show();
                    }
                });

                return tags;
            }
        });
        hideTagsLayout.setAdapter(new TagAdapter<TagBean.DataBean.ListBean>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, final TagBean.DataBean.ListBean datas) {
                TextView tags = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.layout_tags_item, parent, false);
                tags.setText((datas.getKeyword()));
                tags.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "position" + datas.getKeyword(), Toast.LENGTH_SHORT).show();
                    }
                });

                return tags;
            }
        });
    }


    private void initListener() {

        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowMore) {
                    isShowMore = false;

                    hideScrollView.setVisibility(View.VISIBLE);

                    tvMore.setText("收起");
                    tagsLayout.setVisibility(View.GONE);

                    Drawable updrawable = getResources().getDrawable(R.drawable.ic_arrow_up_gray_round);
                    updrawable.setBounds(0, 0, updrawable.getMinimumWidth(), updrawable.getMinimumHeight());
                    tvMore.setCompoundDrawables(updrawable, null, null, null);

                } else {
                    isShowMore = true;
                    hideScrollView.setVisibility(View.GONE);
                    tvMore.setText("查看更多");
                    tagsLayout.setVisibility(View.VISIBLE);
                    Drawable downdrawable = getResources().getDrawable(R.drawable.ic_arrow_down_gray_round);
                    downdrawable.setBounds(0, 0, downdrawable.getMinimumWidth(), downdrawable.getMinimumHeight());
                    tvMore.setCompoundDrawables(downdrawable, null, null, null);
                }
            }
        });
        topicCenterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopicCenterActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
