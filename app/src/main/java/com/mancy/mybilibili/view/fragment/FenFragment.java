package com.mancy.mybilibili.view.fragment;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mancy.mybilibili.Adapter.FenQuAdapter;
import com.mancy.mybilibili.Adapter.ItemAdapter;
import com.mancy.mybilibili.Fragment.BaseFragment;
import com.mancy.mybilibili.Presenter.FenPrsenter;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.FenQuBean;
import com.mancy.mybilibili.gridrView.MyGridView;
import com.mancy.mybilibili.view.FenView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class FenFragment extends BaseFragment implements FenView {


    @InjectView(R.id.gv_partion)
    GridView gvPartion;

    @InjectView(R.id.title_pic)
    ImageView titlePic;
    @InjectView(R.id.titles)
    TextView titles;
    @InjectView(R.id.tv_more_hot)
    TextView tvMoreHot;
    @InjectView(R.id.gv_hot)
    MyGridView gvHot;
    @InjectView(R.id.textView8)
    TextView textView8;
    private ItemAdapter itemAdapter;

    private FenQuBean datas;
    private FenQuAdapter adapter;

    private FenPrsenter prsenter;


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

        prsenter = new FenPrsenter(this);
        itemAdapter = new ItemAdapter(context);
        gvPartion.setAdapter(itemAdapter);

        prsenter.getDataFromNet("http://app.bilibili.com/x/v2/show/");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @Override
    public void onSuccess(FenQuBean fenQuBean) {
        datas = fenQuBean;
        adapter = new FenQuAdapter(context, datas);
        gvHot.setAdapter(adapter);


    }
}
