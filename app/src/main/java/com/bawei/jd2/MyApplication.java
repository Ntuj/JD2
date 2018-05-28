package com.bawei.jd2;

import android.app.Application;

import com.dash.zxinglibrary.activity.ZXingLibrary;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco
        Fresco.initialize(this);
        //初始化Zxing库
        ZXingLibrary.initDisplayOpinion(this);
    }
}
