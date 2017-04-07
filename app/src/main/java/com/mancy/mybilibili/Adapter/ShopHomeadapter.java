package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.ShopHomeBean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/28.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ShopHomeadapter extends BaseAdapter {
    private final ShopHomeBean.ResultBean datas;
    private final Context context;

    public ShopHomeadapter(Context context, ShopHomeBean.ResultBean shopdata) {
        this.context = context;
        this.datas = shopdata;
    }

    @Override
    public int getCount() {
        return datas.getRecords().size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_shophome, null);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(datas.getRecords().get(position).getTitle());
        viewHolder.tvPrice.setText("￥"+datas.getRecords().get(position).getSalvePrice());
        Glide.with(context)
                .load(datas.getRecords().get(position).getImgUrl())
                .into(viewHolder.ivHot);

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_hot)
        ImageView ivHot;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_price)
        TextView tvPrice;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
