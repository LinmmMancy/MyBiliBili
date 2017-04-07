package com.mancy.mybilibili.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mancy.mybilibili.Adapter.OriginalsAdapter;
import com.mancy.mybilibili.Fragment.BaseFragment;
import com.mancy.mybilibili.Presenter.OriginalPrsenter;
import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.OriginalBean;
import com.mancy.mybilibili.view.OriginalView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/24.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */

public class OriginalFragment extends BaseFragment implements OriginalView {

    @InjectView(R.id.rl_recycler)
    RecyclerView rlRecycler;

    private OriginalsAdapter adapter;

    private OriginalPrsenter prsenter;


    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_faxian_original, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        prsenter = new OriginalPrsenter(this);
        prsenter.getDataFromNet("http://app.bilibili.com/x/v2/");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onSuccess(OriginalBean originalBean) {
        OriginalBean data = originalBean;

        adapter = new OriginalsAdapter(context, data);

        rlRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        rlRecycler.setLayoutManager(linearLayoutManager);

    }
}
