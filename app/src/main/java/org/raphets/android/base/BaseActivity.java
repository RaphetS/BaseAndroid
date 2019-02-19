/*
 * ***************************************************************************
 *
 * Copyright (c) 2018.
 * 武汉美美咖科技有限公司版权所有
 * File Last Modified 18-3-9 下午2:18
 * OLD MAN CO.. LTD. ALL RIGHTS RESERVED.
 *  *
 *  ***************************************************************************
 */

package org.raphets.android.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import org.raphets.android.utils.ActivityUtils;
import org.raphets.android.utils.TUtil;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：柯雄枫
 * 时间：2018/3/9/009 14:1
 * 邮箱：915611039@qq.com
 * 描述：BaseActivity 抽象类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate( Bundle arg0) {
        super.onCreate(arg0);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mPresenter = TUtil.getT(this, 0);
        ActivityUtils.getInstance().pushActivity(this);
        //强制 竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initPresenter();
        onCreate();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        ActivityUtils.getInstance().popActivity(this);
    }


    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }


    //布局加载
    protected abstract int getLayoutId();
    //onCreate
    protected abstract void onCreate();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();


}
