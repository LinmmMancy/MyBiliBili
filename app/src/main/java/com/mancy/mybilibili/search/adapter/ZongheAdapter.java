package com.mancy.mybilibili.search.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.search.bean.ZongheBean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/27.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ZongheAdapter extends BaseAdapter {
    private final Context context;
    private final ZongheBean.DataBean.ItemsBean datas;

    public ZongheAdapter(Context context, ZongheBean.DataBean.ItemsBean zonghedata) {
        this.context = context;
        this.datas = zonghedata;
    }

    @Override
    public int getCount() {
        return datas.getArchive().size();
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
            convertView = View.inflate(context, R.layout.zonghe_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.tvXiangqing.setText(datas.getArchive().get(position).getTitle());
        viewHolder.tvXiangqing2.setText(datas.getArchive().get(position).getAuthor());

        viewHolder.tvTv1.setText(datas.getArchive().get(position).getPlay() + "万");
        viewHolder.tvTv2.setText(datas.getArchive().get(position).getDanmaku() + "");
        Glide.with(context)
                .load(datas.getArchive().get(position).getCover())
                .into(viewHolder.ivImage);


        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_image)
        ImageView ivImage;
        @InjectView(R.id.tv_xiangqing)
        TextView tvXiangqing;
        @InjectView(R.id.tv_xiangqing2)
        TextView tvXiangqing2;
        @InjectView(R.id.tv_tv1)
        TextView tvTv1;
        @InjectView(R.id.tv_tv2)
        TextView tvTv2;
        @InjectView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
