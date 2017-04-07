package com.mancy.mybilibili.Presenter;

import com.mancy.mybilibili.bean.OriginalBean;
import com.mancy.mybilibili.model.OriginalModel;
import com.mancy.mybilibili.model.impl.OriginalModelimpl;
import com.mancy.mybilibili.model.onOrginalListener;
import com.mancy.mybilibili.view.OriginalView;
import com.mancy.mybilibili.view.fragment.OriginalFragment;

/**
 * Created by linmingming(林明明) on 2017/4/6.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class OriginalPrsenter {

    private OriginalView originalView;

    private OriginalModel model;


    public OriginalPrsenter(OriginalFragment view) {
        this.originalView = (OriginalView) view;
        this.model = new OriginalModelimpl();
    }

    public void getDataFromNet(String url) {
        model.getDataFromNet(url, new onOrginalListener() {
            @Override
            public void onSuccess(OriginalBean originalBean) {
                originalView.onSuccess(originalBean);
            }
        });
    }

}
