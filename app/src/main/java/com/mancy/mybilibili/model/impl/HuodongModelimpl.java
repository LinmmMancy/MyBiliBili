package com.mancy.mybilibili.model.impl;

import com.mancy.mybilibili.bean.HuoDongBean;
import com.mancy.mybilibili.model.HuodongModel;
import com.mancy.mybilibili.model.getDatas;
import com.mancy.mybilibili.model.onrequestListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linmingming(林明明) on 2017/4/5.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class HuodongModelimpl implements HuodongModel {
    @Override
    public void getDataFromNet(String url, final onrequestListener onrequestListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getDatas getDatas = retrofit.create(getDatas.class);
        Call<HuoDongBean> huodongData = getDatas.getHuodongData();

        huodongData.enqueue(new Callback<HuoDongBean>() {
            @Override
            public void onResponse(Call<HuoDongBean> call, Response<HuoDongBean> response) {
                onrequestListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<HuoDongBean> call, Throwable t) {

            }
        });
    }
}
