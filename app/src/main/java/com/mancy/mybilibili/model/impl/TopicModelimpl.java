package com.mancy.mybilibili.model.impl;

import com.mancy.mybilibili.bean.ToppicBean;
import com.mancy.mybilibili.model.TopicModel;
import com.mancy.mybilibili.model.getDatas;
import com.mancy.mybilibili.model.ontopicListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linmingming(林明明) on 2017/4/6.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class TopicModelimpl implements TopicModel {

    @Override
    public void getDataFromNet(String url, final ontopicListener onrequestListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getDatas getDatas = retrofit.create(getDatas.class);
        Call<ToppicBean> topicData = getDatas.getTopicData();
        topicData.enqueue(new Callback<ToppicBean>() {
            @Override
            public void onResponse(Call<ToppicBean> call, Response<ToppicBean> response) {
                onrequestListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ToppicBean> call, Throwable t) {

            }
        });
    }
}
