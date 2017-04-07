package com.mancy.mybilibili.model;

import com.mancy.mybilibili.bean.ToppicBean;

/**
 * Created by linmingming(林明明) on 2017/4/5.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public interface ontopicListener {

    /**
     * 成功时的回调和失败的回调
     */
    void onSuccess(ToppicBean toppicBean);

    void onFailedError(Exception e);

}
