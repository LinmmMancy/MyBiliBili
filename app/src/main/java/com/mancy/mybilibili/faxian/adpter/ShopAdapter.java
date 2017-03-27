package com.mancy.mybilibili.faxian.adpter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mancy.mybilibili.faxian.bean.ShopBean;
import com.mancy.mybilibili.faxian.fragment.ShopActivity;

/**
 * Created by linmingming(林明明) on 2017/3/27.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ShopAdapter extends BaseAdapter {

    private final ShopBean.ResultBean datas;
    private final ShopActivity context;

    public ShopAdapter(ShopActivity context, ShopBean.ResultBean datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.getModelDetails().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
