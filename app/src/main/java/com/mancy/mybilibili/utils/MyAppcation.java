package com.mancy.mybilibili.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by Mancy on 2017/3/12.
 */

public class MyAppcation extends Application {

    private static Context context;
    private static Thread mainThread;
    private static int threadid;
    private static Handler handler;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        threadid = android.os.Process.myPid();
        handler = new Handler();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

     //   CrashHandler.getInstance().init();

        //初始化未捕获异常 上线的时候才打开
        //CrashHandler.getInstance().init();
    }

    public static Context getContext() {
        return context;

    }

    public static Thread getMainThread() {
        return mainThread;

    }

    public static int getThreadid() {
        return threadid;

    }

    public static Handler getHandler() {
        return handler;

    }


    /**
     * 四种线程池
     *
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
