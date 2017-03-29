package com.mancy.mybilibili.faxian.fragment;


import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mancy.mybilibili.BaseFragment;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.faxian.adpter.ShoppingCartAdapter;
import com.mancy.mybilibili.faxian.bean.ShopXiangqing;
import com.mancy.mybilibili.gen.MyApplication;
import com.mancy.mybilibili.gen.ShopXiangqingDao;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/28.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class ShopCarFragment extends BaseFragment {
    @InjectView(R.id.tv_shopcart_edit)
    TextView tvShopcartEdit;
    @InjectView(R.id.recyclerview)
    ListView recyclerview;
    @InjectView(R.id.checkbox_all)
    CheckBox checkboxAll;
    @InjectView(R.id.tv_shopcart_total)
    TextView tvShopcartTotal;
    @InjectView(R.id.btn_check_out)
    Button btnCheckOut;
    @InjectView(R.id.ll_check_all)
    LinearLayout llCheckAll;
    @InjectView(R.id.checkbox_delete_all)
    CheckBox checkboxDeleteAll;
    @InjectView(R.id.btn_delete)
    Button btnDelete;
    @InjectView(R.id.btn_collection)
    Button btnCollection;
    @InjectView(R.id.ll_delete)
    LinearLayout llDelete;



    private ShoppingCartAdapter adapter;

    private ShopXiangqingDao shopXiangqingDao;


    @Override
    public View initView() {
//        textView = new TextView(context);
//        textView.setTextSize(30);
//        textView.setGravity(Gravity.CENTER);
//
//        textView.setTextColor(Color.RED);

        View view = View.inflate(context, R.layout.activity_shopping_acativity, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        shopXiangqingDao= MyApplication.getInstances().getDaoSession().getShopXiangqingDao();
        List<ShopXiangqing> list =  shopXiangqingDao.loadAll();
        Log.e("TAG", "initData1111111111111111111111111111111111111: "+list.size());
        adapter = new ShoppingCartAdapter(context,list,checkboxAll,checkboxDeleteAll);

        recyclerview.setAdapter(adapter);
        recyclerview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}
