package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.TuiJianBean;
import com.mancy.mybilibili.shiping.DanmkuVideoActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/22.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class TuiJianAdapter extends BaseAdapter {


    private final Context context;
    private final List<TuiJianBean.DataBean> data;

    public TuiJianAdapter(Context context, List<TuiJianBean.DataBean> datas) {
        this.context = context;
        this.data = datas;
    }


    @Override
    public int getCount() {
        return data.size();
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
            convertView = View.inflate(context, R.layout.tuijian_item_view, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(data.get(position).getName());
        viewHolder.tvContent.setText(data.get(position).getTitle());
        Glide.with(context)
                .load(data.get(position).getCover())
                .into(viewHolder.ibPicture);
        viewHolder.itemLiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DanmkuVideoActivity.class));
            }
        });


        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.ibPicture)
        ImageView ibPicture;
        @InjectView(R.id.tv_play)
        TextView tvPlay;
        @InjectView(R.id.tv_danmu)
        TextView tvDanmu;
        @InjectView(R.id.tv_time)
        TextView tvTime;
        @InjectView(R.id.tvContent)
        TextView tvContent;
        @InjectView(R.id.tvName)
        TextView tvName;
        @InjectView(R.id.item_live_layout)
        CardView itemLiveLayout;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
