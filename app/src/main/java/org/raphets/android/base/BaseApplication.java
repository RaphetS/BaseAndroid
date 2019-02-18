package org.raphets.android.base;

import android.app.Application;

import org.raphets.android.other.InitializeService;

public class BaseApplication extends Application {
    private static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        InitializeService.start(this);

    }

    public static BaseApplication getInstance(){
        return mContext;
    }
}
