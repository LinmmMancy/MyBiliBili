package com.mancy.mybilibili.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mancy.mybilibili.R;

public class WelcomeActivity extends AppCompatActivity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActvity();
            }


        }, 500);
    }

    private void startMainActvity() {

        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "欢迎来到哔哩哔哩(*^__^*) 嘻嘻……", Toast.LENGTH_SHORT).show();
//        ToastUtil.showSuccessMsg("qweqeqweqwe");

        // 关闭

        finish();
    }



    @Override
    protected void onDestroy() {

        super.onDestroy();
        handler.removeCallbacksAndMessages(null);

    }
}
