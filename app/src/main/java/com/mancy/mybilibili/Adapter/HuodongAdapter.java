package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.HuoDongBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/24.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class HuodongAdapter extends BaseAdapter {
    private final Context context;
    private final List<HuoDongBean.ListBean> datas;

    public HuodongAdapter(Context context, List<HuoDongBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;

    }

    @Override
    public int getCount() {
        return datas.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;


        if (convertView == null) {
            convertView = View.inflate(context, R.layout.topic_item, null);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(datas.get(position).getTitle());
        Glide.with(context)
                .load(datas.get(position).getCover())
                .into(viewHolder.ivPhoto);
        viewHolder.cdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + datas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }


    class ViewHolder {
        @InjectView(R.id.iv_photo)
        ImageView ivPhoto;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.cd_view)
        CardView cdView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
