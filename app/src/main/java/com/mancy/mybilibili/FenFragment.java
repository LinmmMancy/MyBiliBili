package com.mancy.mybilibili;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.mancy.mybilibili.gridrView.GridrView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by linmingming(林明明) on 2017/3/21.
 * QQ ：519660797
 * Tel: 17600305015
 * 作用：
 */
public class FenFragment extends BaseFragment {


    @InjectView(R.id.gridview)
    GridView gridview;

    @Override
    public View initView() {


        View view = View.inflate(context, R.layout.fragment_fen, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        gridview.setAdapter(new GridrView(getActivity()));
        //单击GridView元素的响应
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //弹出单击的GridView元素的位置
                Toast.makeText(getActivity(), mThumbIds[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


    //展示图片
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


}
