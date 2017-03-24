package com.mancy.mybilibili;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

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


        }, 2000);
    }

    private void startMainActvity() {

        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "欢迎来到哔哩哔哩(*^__^*) 嘻嘻……", Toast.LENGTH_SHORT).show();

        // 关闭

        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // 立即进入
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            startMainActvity();

            return true;
        }


        return super.onTouchEvent(event);

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        handler.removeCallbacksAndMessages(null);

    }
}
