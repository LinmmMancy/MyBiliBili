package com.mancy.mybilibili;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/22.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ItemAdapter extends BaseAdapter {

    private final Context context;
    private Integer[] mThumbIds = {
            R.drawable.ic_category_t13, R.drawable.ic_category_t13,
            R.drawable.ic_category_t1, R.drawable.ic_category_t3,
            R.drawable.ic_category_t129, R.drawable.ic_category_t4,
            R.drawable.ic_category_t36, R.drawable.ic_category_t160,
            R.drawable.ic_category_t119, R.drawable.ic_category_t155,
            R.drawable.ic_category_t165, R.drawable.ic_category_t5,
            R.drawable.ic_category_t23, R.drawable.ic_category_t11,
            R.drawable.ic_category_game_center,

    };
    private String[] mText = {"直播", "番剧",
            "动画", "音乐",
            "舞蹈", "游戏",
            "科技", "生活",
            "鬼畜", "时尚",
            "广告", "娱乐",
            "电影", "电视剧",
            "游戏中心",


    };

    public ItemAdapter(Context context) {
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
            convertView = View.inflate(context, R.layout.item_channel, null);
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

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
