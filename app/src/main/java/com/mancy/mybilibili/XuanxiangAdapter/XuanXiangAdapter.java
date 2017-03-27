package com.mancy.mybilibili.XuanxiangAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mancy.mybilibili.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/23.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class XuanXiangAdapter extends BaseAdapter {
    private final Context context;
    private Integer[] mThumbIds = {
            R.drawable.live_home_follow_anchor,
            R.drawable.live_home_live_center,
            R.drawable.live_home_search_room,
            R.drawable.live_home_all_category,

    };
    private String[] mText = {
            "关注", "中心",
            "搜索", "分类",
    };


    public XuanXiangAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return mThumbIds.length;
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
            convertView = View.inflate(context, R.layout.item_view_for, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.ivItemPartion.setImageResource(mThumbIds[position]);
        viewHolder.tvItemPartion.setText(mText[position]);


        return convertView;
    }


    class ViewHolder {
        @InjectView(R.id.iv_item_partion)
        ImageView ivItemPartion;
        @InjectView(R.id.tv_item_partion)
        TextView tvItemPartion;
        @InjectView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
