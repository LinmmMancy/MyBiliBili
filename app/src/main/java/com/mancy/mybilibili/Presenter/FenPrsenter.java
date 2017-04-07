package com.mancy.mybilibili.Presenter;

import com.mancy.mybilibili.bean.FenQuBean;
import com.mancy.mybilibili.model.FenModel;
import com.mancy.mybilibili.model.impl.FenModelimpl;
import com.mancy.mybilibili.model.onFenListener;
import com.mancy.mybilibili.view.fragment.FenFragment;
import com.mancy.mybilibili.view.FenView;

/**
 * Created by linmingming(林明明) on 2017/4/6.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class FenPrsenter {
    private FenView fenView;
    private FenModel fenModel;

    public FenPrsenter(FenFragment view) {
        this.fenView = (FenView) view;
        this.fenModel = new FenModelimpl();
    }

    public void getDataFromNet(String url) {
        fenModel.getDataFromNet(url, new onFenListener() {
            @Override
            public void onSuccess(FenQuBean fenQuBean) {
                fenView.onSuccess(fenQuBean);

            }

            @Override
            public void onFailedError(Exception e) {

            }
        });
    }
}
