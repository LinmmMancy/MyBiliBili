package com.mancy.mybilibili.view;

import com.mancy.mybilibili.bean.HuoDongBean;

/**
 * Created by linmingming(林明明) on 2017/4/5.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public interface HuodongView {


    void onsuccess(HuoDongBean huoDongBean);

    void showFailedError(Exception e);


}
