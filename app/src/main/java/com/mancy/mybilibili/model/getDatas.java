package com.mancy.mybilibili.model;

import com.mancy.mybilibili.bean.FenQuBean;
import com.mancy.mybilibili.bean.HuoDongBean;
import com.mancy.mybilibili.bean.OriginalBean;
import com.mancy.mybilibili.bean.ToppicBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by linmingming(林明明) on 2017/4/6.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public interface getDatas {

    @GET("region?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&platform=android&ts=1490014674000&sign=93edb7634f38498a60e5c3ad0b8b0974")
    Call<FenQuBean> getData();

    @GET("rank?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&order=origin&platform=android&pn=1&ps=20&ts=1490015891000&sign=1a5a1c73e3b23be37fb13ee0178ceef0")
    Call<OriginalBean> getOrginalData();

    @GET("getlist?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&page=1&pageSize=20&platform=android&ts=1490338432000&sign=f7265d81f829a0ec759bb09fa93001f1")
    Call<HuoDongBean> getHuodongData();

    @GET("getlist?appkey=1d8b6e7d45233436&build=501000&mobi_app=android&page=1&pageSize=20&platform=android&ts=1490015740000&sign=be68382cdc99c168ef87f2fa423dd280")
    Call<ToppicBean> getTopicData();

}

