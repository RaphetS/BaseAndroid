/*
 * ***************************************************************************
 *
 * Copyright (c) 2018.
 * 武汉美美咖科技有限公司版权所有
 * File Last Modified 18-3-9 下午1:24
 * OLD MAN CO.. LTD. ALL RIGHTS RESERVED.
 *  *
 *  ***************************************************************************
 */

package org.raphets.android.base;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import org.raphets.android.utils.ActivityUtils;

import java.util.ArrayList;

/**
 * @文件名称：BaseActivity
 * @文件作者：柯雄枫
 * @时间：2018/3/10/010 16:50
 * @邮箱：915611039@qq.com
 * @文件描述：Activity基类
 */
public class BaseActivity extends AppCompatActivity {

    private ArrayList<String> mReceiveActions = new ArrayList<String>();
    //onCreate
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        ActivityUtils.getInstance().pushActivity(this);
        //强制 竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
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
}
