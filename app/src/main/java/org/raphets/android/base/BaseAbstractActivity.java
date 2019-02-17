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
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import org.raphets.android.utils.TUtil;

/**
 * 作者：柯雄枫
 * 时间：2018/3/9/009 14:1
 * 邮箱：915611039@qq.com
 * 描述：BaseActivity 抽象类
 */
public abstract class BaseAbstractActivity<T extends BasePresenter, E extends BaseModel> extends Activity {
    public T mPresenter;
    public E mModel;


    @Override
    protected void onCreate( Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(getLayoutId());
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        initPresenter();
        onCreate();
    }


    public void setImmersiveWhite() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { //4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | localLayoutParams.flags);

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //android6.0以后可以对状态栏文字颜色和图标进行修改
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }



    //布局加载
    protected abstract int getLayoutId();
    //onCreate
    protected abstract void onCreate();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();


}
