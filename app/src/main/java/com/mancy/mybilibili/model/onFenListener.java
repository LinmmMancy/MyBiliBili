package com.mancy.mybilibili.model;

import com.mancy.mybilibili.bean.FenQuBean;

/**
 * Created by linmingming(林明明) on 2017/4/6.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public interface onFenListener {
    /**
     * 成功时的回调和失败的回调
     */
    void onSuccess(FenQuBean fenQuBean);

    void onFailedError(Exception e);
}
