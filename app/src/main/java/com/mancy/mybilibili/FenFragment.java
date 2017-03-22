package com.mancy.mybilibili;

import android.view.View;
import android.widget.GridView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class FenFragment extends BaseFragment {


    @InjectView(R.id.gv_partion)
    GridView gvPartion;
    private ItemAdapter itemAdapter;


    //partition

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_fen, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        itemAdapter = new ItemAdapter(context);
        gvPartion.setAdapter(itemAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}
