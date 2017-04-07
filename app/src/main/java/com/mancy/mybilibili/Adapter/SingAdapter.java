package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.DirecTvInfo;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/22.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class SingAdapter extends BaseAdapter {
    private final Context context;
    private final List<DirecTvInfo.DataBean.PartitionsBean> datas;

    public SingAdapter(Context context, List<DirecTvInfo.DataBean.PartitionsBean> partitions) {
        this.context = context;
        this.datas = partitions;
    }

    @Override
    public int getCount() {
        return 4;
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
            convertView = View.inflate(context, R.layout.sing_view_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(datas.get(position).getLives().get(2).getOwner().getName());
        viewHolder.tvContent.setText(datas.get(position).getLives().get(2).getTitle());
     //   viewHolder.tvWatchingNumber.setText(datas.get(position).getLives().get(3).getOnline() + "");
        Glide.with(context)
                .load(datas.get(position).getLives().get(2).getCover().getSrc())
                .into(viewHolder.ibPicture);

        return convertView;
    }



    class ViewHolder {
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
