package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.OriginalBean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/24.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class OriginalAdapter extends BaseAdapter {
    private final Context context;
    private final OriginalBean datas;


    public OriginalAdapter(Context context, OriginalBean originalBean) {
        this.context = context;
        this.datas = originalBean;

    }

    @Override
    public int getCount() {
        return datas.getData().size();
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
            convertView = View.inflate(context, R.layout.original_adapter_item, null);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvXuhao.setText(position + 1 + "");
        if (position < 3) {
            for (int i = 0; i <= 3; i++) {
                viewHolder.tvXuhao.setTextColor(Color.parseColor("#FB7299"));

            }

        }

        viewHolder.tvXiangqing2.setText(datas.getData().get(position).getName() + "");
        viewHolder.tvXiangqing3.setText("综合评价 " + datas.getData().get(position).getPts() + "");

        viewHolder.tvXiangqing.setText(datas.getData().get(position).getTitle());

        Glide.with(context)
                .load(datas.getData().get(position).getCover())
                .into(viewHolder.ivImage);

        return convertView;
    }



    class ViewHolder {
        @InjectView(R.id.tv_xuhao)
        TextView tvXuhao;
        @InjectView(R.id.iv_image)
        ImageView ivImage;
        @InjectView(R.id.tv_xiangqing)
        TextView tvXiangqing;
        @InjectView(R.id.tv_xiangqing2)
        TextView tvXiangqing2;
        @InjectView(R.id.tv_xiangqing3)
        TextView tvXiangqing3;
        @InjectView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
