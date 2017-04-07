package com.mancy.mybilibili.Presenter;

import com.mancy.mybilibili.bean.HuoDongBean;
import com.mancy.mybilibili.model.HuodongModel;
import com.mancy.mybilibili.model.impl.HuodongModelimpl;
import com.mancy.mybilibili.model.onrequestListener;
import com.mancy.mybilibili.view.HuodongView;

/**
 * Created by linmingming(林明明) on 2017/4/5.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class HuodongPrsenter {


    private HuodongView huodongView;

    private HuodongModel huodongModel;

    public HuodongPrsenter(HuodongView view) {
        this.huodongView = view;
        this.huodongModel = new HuodongModelimpl();
    }


    public void getDataFromNet(String url) {


        huodongModel.getDataFromNet(url, new onrequestListener() {
            @Override
            public void onSuccess(HuoDongBean huoDongBean) {
                huodongView.onsuccess(huoDongBean);

            }

            @Override
            public void onFailedError(Exception e) {
                huodongView.showFailedError(e);
            }
        });
    }


}
