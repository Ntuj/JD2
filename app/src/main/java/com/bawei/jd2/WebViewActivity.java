package com.bawei.jd2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {
    @BindView(R.id.wv)
    WebView wv;
    private String detailUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        //接收地址
        Intent intent = getIntent();
        detailUrl = intent.getStringExtra("detailUrl");
        initView();
        wv.loadUrl(detailUrl);
    }

    private void initView() {
        WebSettings settings = wv.getSettings();
        //支持js
        settings.setJavaScriptEnabled(true);
    }
}
