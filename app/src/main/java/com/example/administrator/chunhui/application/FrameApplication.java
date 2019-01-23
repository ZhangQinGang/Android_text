package com.example.administrator.chunhui.application;

import android.app.Application;
import android.content.Context;

public class FrameApplication extends Application{
    public static FrameApplication mFramApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mFramApplication=this;
    }

    public static Context getContext() {
        return mFramApplication.getApplicationContext();
    }

    public static FrameApplication getApplication() {
        return mFramApplication;
    }
}
