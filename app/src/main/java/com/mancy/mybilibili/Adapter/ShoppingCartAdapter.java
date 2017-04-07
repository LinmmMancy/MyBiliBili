package com.mancy.mybilibili.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.ShopXiangqing;
import com.mancy.mybilibili.gen.MyApplication;
import com.mancy.mybilibili.gen.ShopXiangqingDao;
import com.mancy.mybilibili.utils.AddSubView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/29.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class ShoppingCartAdapter extends BaseAdapter {
    private final Context context;
    public final List<ShopXiangqing> data;
    private final CheckBox checkboxAll;
    private final CheckBox checkboxDeleteAll;
    private final TextView tvshoptotal;

    private ShopXiangqingDao shopXiangqingDao;
    private List<ShopXiangqing> shopXiangqings;


    public ShoppingCartAdapter(Context context
            , List<ShopXiangqing> list
            , CheckBox checkboxAll
            , CheckBox checkboxDeleteAll, TextView tvShopcartTotal) {

        this.context = context;
        this.data = list;
        this.checkboxAll = checkboxAll;
        this.checkboxDeleteAll = checkboxDeleteAll;
        this.tvshoptotal = tvShopcartTotal;
        showTotalPrice();

        shopXiangqingDao = MyApplication.getInstances().getDaoSession().getShopXiangqingDao();
        shopXiangqings = shopXiangqingDao.loadAll();
    }

    public void showTotalPrice() {
        tvshoptotal.setText("合计:" + getTotalPrice());
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        if (data != null && data.size() > 0)

            for (int i = 0; i < data.size(); i++) {

//                GoodsBean goodsBean = data.get(i);
                ShopXiangqing shopXiangqing = data.get(i);
                if (shopXiangqing.getIscked()) {
                    totalPrice += Double.parseDouble(shopXiangqing.getJiage()) * shopXiangqing.getNumber();
                }

            }
        return totalPrice;
    }

    @Override
    public int getCount() {
        return data.size();
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
            convertView = View.inflate(context, R.layout.item_shop_cart, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvDescGov.setText(data.get(position).getTitle());
        viewHolder.tvPriceGov.setText(data.get(position).getJiage() + "");
        viewHolder.addSubView.setValue(1);
        viewHolder.addSubView.setMinValue(100);
        Glide.with(context)
                .load(data.get(position).getPhoto())
                .into(viewHolder.ivGov);


        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.cb_gov)
        CheckBox cbGov;
        @InjectView(R.id.iv_gov)
        ImageView ivGov;
        @InjectView(R.id.tv_desc_gov)
        TextView tvDescGov;
        @InjectView(R.id.tv_price_gov)
        TextView tvPriceGov;
        @InjectView(R.id.addSubView)
        AddSubView addSubView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    public void checkAll() {
        if (data != null && data.size() > 0) {
            int number = 0;
            for (int i = 0; i < data.size(); i++) {
//                GoodsBean goodsBean = datas.get(i);
                ShopXiangqing shopXiangqing = data.get(i);
                if (!shopXiangqing.getIscked()) {
                    // 只要一个不勾选
                    checkboxAll.setChecked(false);

                    checkboxDeleteAll.setChecked(false);


                } else {

                    // 都选
                    number++;
                }
            }


            if (data.size() == number) {

                // 有数据

                checkboxAll.setChecked(true);

                checkboxDeleteAll.setChecked(true);

            } else {
                checkboxAll.setChecked(false);
                checkboxDeleteAll.setChecked(false);
            }
        }
    }

    public void deleteData() {
        shopXiangqingDao.deleteAll();
        notifyDataSetChanged();
    }

    public void checkAll_none(boolean isChecked) {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
//                GoodsBean goodsBean = data.get(i);

                ShopXiangqing shopXiangqing = data.get(i);
                shopXiangqing.setIscked(isChecked);
                checkboxAll.setChecked(isChecked);

                checkboxDeleteAll.setChecked(isChecked);

                notifyDataSetChanged();

            }
        }

    }


    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
