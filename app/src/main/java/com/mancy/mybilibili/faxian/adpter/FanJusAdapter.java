package com.mancy.mybilibili.faxian.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mancy.mybilibili.R;
import com.mancy.mybilibili.faxian.bean.FanJuBean;
import com.mancy.mybilibili.gridrView.MyListView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/25.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class FanJusAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final FanJuBean datas;

    private LayoutInflater inflater;

    public FanJusAdapter(Context context, FanJuBean datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FanJuViewHolder fanJuViewHolder = (FanJuViewHolder) holder;
        fanJuViewHolder.setData(context,datas.getData());

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FanJuViewHolder(context, inflater.inflate(R.layout.yuanchuan_view, null));

    }

    class FanJuViewHolder extends RecyclerView.ViewHolder {

        private final Context context;
        @InjectView(R.id.lv_listview)
        MyListView lvListview;
        FanJuAdapter adapter;

        public FanJuViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.inject(this, itemView);
        }

        public void setData(final Context context, final List<FanJuBean.DataBean> data) {
            adapter = new FanJuAdapter(context,data);
            lvListview.setAdapter(adapter);
            lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, ""+data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return 1;
    }
}
