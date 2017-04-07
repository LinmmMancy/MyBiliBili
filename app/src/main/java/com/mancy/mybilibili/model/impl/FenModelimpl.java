package com.mancy.mybilibili.model.impl;

import com.mancy.mybilibili.bean.FenQuBean;
import com.mancy.mybilibili.model.FenModel;
import com.mancy.mybilibili.model.getDatas;
import com.mancy.mybilibili.model.onFenListener;

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

public class FenModelimpl implements FenModel {


    @Override
    public void getDataFromNet(String url, final onFenListener onFenListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getDatas getDatas = retrofit.create(getDatas.class);

        Call<FenQuBean> data = getDatas.getData();
        data.enqueue(new Callback<FenQuBean>() {
            @Override
            public void onResponse(Call<FenQuBean> call, Response<FenQuBean> response) {
                onFenListener.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<FenQuBean> call, Throwable t) {

            }
        });
    }
}

