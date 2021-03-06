package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.RunPlayBean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/22.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ZhuiFanAdapter2 extends BaseAdapter {


    private final Context context;
    private final RunPlayBean.ResultBean datas;


    public ZhuiFanAdapter2(Context context, RunPlayBean.ResultBean result) {
        this.context = context;
        this.datas = result;
    }

    @Override
    public int getCount() {
        return datas.getSerializing().size();
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
            convertView = View.inflate(context, R.layout.zhuifan_item_views, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.itemRunplayName.setText(
                datas.getSerializing().get(position).getTitle());
        viewHolder.itemRunplayNumber.setText(
                datas.getSerializing().get(position).getFavourites() + "人");
        viewHolder.itemUpdateNumber.setText(
                "更新到第" + datas.getSerializing().get(position).getNewest_ep_index() + "话");
        Glide.with(context)
                .load(datas.getSerializing().get(position).getCover())
                .into(viewHolder.ivItemRunplay);


        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_item_runplay)
        ImageView ivItemRunplay;
        @InjectView(R.id.item_runplay_number)
        TextView itemRunplayNumber;
        @InjectView(R.id.item_runplay_name)
        TextView itemRunplayName;
        @InjectView(R.id.item_update_number)
        TextView itemUpdateNumber;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
