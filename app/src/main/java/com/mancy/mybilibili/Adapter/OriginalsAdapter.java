package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.OriginalBean;
import com.mancy.mybilibili.gridrView.MyListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/24.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class OriginalsAdapter extends RecyclerView.Adapter {
    private final Context context;



    private OriginalBean beanList;

    private LayoutInflater inflater;


    public OriginalsAdapter(Context context, OriginalBean data) {
        this.context = context;
        this.beanList = data;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        YuanChuanViewHolder yuanChuanViewHolder = (YuanChuanViewHolder) holder;

        yuanChuanViewHolder.setData(beanList);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YuanChuanViewHolder(context, inflater.inflate(R.layout.yuanchuan_view, null));
    }

    class YuanChuanViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.lv_listview)
        MyListView lvListview;
        OriginalAdapter adapter;

        private final Context context;

        public YuanChuanViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);

        }


        public void setData(OriginalBean originalBean) {
            adapter = new OriginalAdapter(context, originalBean);

            lvListview.setAdapter(adapter);
            lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                }
            });
            lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, ""+beanList.getData().get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return 1;
    }
}
