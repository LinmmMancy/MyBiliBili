package com.mancy.mybilibili.Presenter;

import com.mancy.mybilibili.bean.ToppicBean;
import com.mancy.mybilibili.view.actvityMvp.TopicCenterActivity;
import com.mancy.mybilibili.view.TopicView;
import com.mancy.mybilibili.model.TopicModel;
import com.mancy.mybilibili.model.impl.TopicModelimpl;
import com.mancy.mybilibili.model.ontopicListener;

/**
 * Created by linmingming(林明明) on 2017/4/6.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class TopicPrsenter {
    private TopicModel topicModel;
    private TopicView topicView;

    public TopicPrsenter(TopicCenterActivity view) {
        this.topicView = view;
        this.topicModel = new TopicModelimpl();
    }


    public void getDataFromNet(String url) {
        topicModel.getDataFromNet(url, new ontopicListener() {
            @Override
            public void onSuccess(ToppicBean toppicBean) {
                topicView.onSuccess(toppicBean);


            }

            @Override
            public void onFailedError(Exception e) {


            }
        });
    }


}
