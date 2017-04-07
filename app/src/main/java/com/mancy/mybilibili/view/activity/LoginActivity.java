package com.mancy.mybilibili.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mancy.mybilibili.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {


    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.left_show)
    ImageView leftShow;
    @InjectView(R.id.iv_bilibili)
    ImageView ivBilibili;
    @InjectView(R.id.right_show)
    ImageView rightShow;
    @InjectView(R.id.et_user)
    EditText etUser;
    @InjectView(R.id.tv_tv1)
    TextView tvTv1;
    @InjectView(R.id.ll_user)
    LinearLayout llUser;
    @InjectView(R.id.et_paw)
    EditText etPaw;
    @InjectView(R.id.tv_tv2)
    TextView tvTv2;
    @InjectView(R.id.ll_paw)
    LinearLayout llPaw;
    @InjectView(R.id.activity_login)
    LinearLayout activityLogin;
    @InjectView(R.id.tv_wangjipaw)
    TextView tvWangjipaw;
    @InjectView(R.id.bt_zhuce)
    Button btZhuce;
    @InjectView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        initlistener();
    }

    private void initlistener() {


        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });


        tvWangjipaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "请联系客服哦 (*^__^*) 嘻嘻……", Toast.LENGTH_SHORT).show();
            }
        });

        btZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    leftShow.setImageResource(R.drawable.ic_22);
                    rightShow.setImageResource(R.drawable.ic_33);

                } else {
                    leftShow.setImageResource(R.drawable.ic_22_hide);
                    rightShow.setImageResource(R.drawable.ic_33_hide);
                }

            }
        });

        etPaw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    leftShow.setImageResource(R.drawable.ic_22_hide);
                    rightShow.setImageResource(R.drawable.ic_33_hide);

                } else {
                    leftShow.setImageResource(R.drawable.ic_22);
                    rightShow.setImageResource(R.drawable.ic_33);
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
