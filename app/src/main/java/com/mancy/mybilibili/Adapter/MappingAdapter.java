package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
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

public class MappingAdapter extends BaseAdapter {

    private final Context context;
    private final List<DirecTvInfo.DataBean.PartitionsBean> datas;

    public MappingAdapter(Context context, List<DirecTvInfo.DataBean.PartitionsBean> partitions) {
        this.context = context;
        this.datas = partitions;
        Log.e("TAG", "MappingAdapter: 33333333333333333333333333333333333333333333333333333");
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
        Log.e("TAG", "getView: 44444444444444444444444");
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.maiping_item_view, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvContent.setText(datas.get(position).getLives().get(1).getTitle());

        Log.e("TAG", "getView: 22222222222222222222222222222222222");
        viewHolder.tvName.setText(datas.get(position).getLives().get(1).getOwner().getName());
//        viewHolder.tvWatchingNumber.setText(datas.get(position).getLives().get(1).getOnline() + "");
        Glide.with(context)
                .load(datas.get(position).getLives().get(position).getCover().getSrc()
                )

                .into(viewHolder.ibPicture);

        //设置数据

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
