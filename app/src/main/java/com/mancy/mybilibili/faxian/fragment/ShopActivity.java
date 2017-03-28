package com.mancy.mybilibili.faxian.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mancy.mybilibili.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShopActivity extends AppCompatActivity {


    @InjectView(R.id.tb_home)
    RadioButton tbHome;
    @InjectView(R.id.rb_car)
    RadioButton rbCar;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;
    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.iv_back)
    ImageView ivBack;

    private ArrayList<Fragment> fragments;

    private int position;

    private Fragment tempftagment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.inject(this);
        initFragment();

        initListener();


    }

    private void initFragment() {

        fragments = new ArrayList<>();

        fragments.add(new ShopHomeFragment());
        fragments.add(new ShopCarFragment());


    }


    private void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.tb_home:

                        position = 0;

                        break;
                    case R.id.rb_car:
                        position = 1;

                        break;

                }

                // 根据不同的fragment 切换到相应的页面

                Fragment currentfragment = fragments.get(position);

                switchFragment(currentfragment);


            }
        });
        rgMain.check(R.id.tb_home);
    }

    private void switchFragment(Fragment currentfragment) {

        //   切换的不同的页面
        if (tempftagment != currentfragment) {

            // 得到 fragmentmanner

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            // 如果没有添加
            if (!currentfragment.isAdded()) {

                // 缓存的隐藏

                if (tempftagment != null) {
                    ft.hide(tempftagment);
                }

                // 添加

                ft.add(R.id.fl_main, currentfragment);
            } else {
                // 缓存的隐藏

                if (tempftagment != null) {


                    ft.hide(tempftagment);

                }

                // 显示

                ft.show(currentfragment);
            }

            // 事务的提交

            ft.commit();

            //  把当前的赋值设置成缓存

            tempftagment = currentfragment;


        }
    }

}
