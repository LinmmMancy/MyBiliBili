package com.mancy.mybilibili.TuiJian;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.DirecTvInfo;

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
    private final DirecTvInfo.DataBean datas;

    public TuiJianAdapter(Context context, DirecTvInfo.DataBean data) {
        this.context = context;
        this.datas = data;

    }


    @Override
    public int getCount() {
        return datas.getPartitions().size();
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

        viewHolder.tvName.setText(datas.getPartitions().get(position).getLives().get(5).getOwner().getName());
        viewHolder.tvContent.setText(datas.getPartitions().get(position).getLives().get(5).getTitle());
        Glide.with(context)
                .load(datas.getPartitions().get(position).getLives().get(5).getCover().getSrc())
                .into(viewHolder.ibPicture);

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.ib_picture)
        ImageView ibPicture;
        @InjectView(R.id.tv_content)
        TextView tvContent;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_name2)
        TextView tvName2;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
