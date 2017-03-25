package com.mancy.mybilibili.LiveAdapter;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mancy.mybilibili.R;
import com.mancy.mybilibili.bean.DirecTvInfo;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WebView extends AppCompatActivity {

    private DirecTvInfo.DataBean.BannerBean datas;


    @InjectView(R.id.webview)
    android.webkit.WebView webview;
    @InjectView(R.id.activity_web_view)
    LinearLayout activityWebView;
    @InjectView(R.id.ib_back)
    ImageButton ibBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.ib_more)
    ImageButton ibMore;
    private String link;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.inject(this);
        initData();
    }

    protected void initData() {
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String title = getIntent().getStringExtra(LiveAdapter.NAME);
        String link = getIntent().getStringExtra(LiveAdapter.NAME1);




        tvTitle.setText(title);
        webview.loadUrl(link);


        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);  //支持js
        webSettings.setUseWideViewPort(false);  //将图片调整到适合webview的大小
        webSettings.setSupportZoom(true);  //支持缩放

        webview.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.webview.loadUrl(datas.getLink());
                }
                return true;
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.webview.loadUrl(datas.getLink());

                return true;
            }

        });
    }
}