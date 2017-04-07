package com.mancy.mybilibili.model.impl;

import com.mancy.mybilibili.bean.OriginalBean;
import com.mancy.mybilibili.model.OriginalModel;
import com.mancy.mybilibili.model.getDatas;
import com.mancy.mybilibili.model.onOrginalListener;

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

public class OriginalModelimpl implements OriginalModel {
    @Override
    public void getDataFromNet(String url, final onOrginalListener onOrginalListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getDatas getDatas = retrofit.create(getDatas.class);

        Call<OriginalBean> orginalData = getDatas.getOrginalData();
        orginalData.enqueue(new Callback<OriginalBean>() {
            @Override
            public void onResponse(Call<OriginalBean> call, Response<OriginalBean> response) {
                onOrginalListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<OriginalBean> call, Throwable t) {

            }
        });
    }
}
