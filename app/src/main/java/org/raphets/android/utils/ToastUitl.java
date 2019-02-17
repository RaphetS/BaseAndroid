/*
 * ***************************************************************************
 *
 * Copyright (c) 2018.
 * 武汉美美咖科技有限公司版权所有
 * File Last Modified 17-11-10 下午4:15
 * OLD MAN CO.. LTD. ALL RIGHTS RESERVED.
 *  *
 *  ***************************************************************************
 */

package org.raphets.android.utils;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;


import org.raphets.android.R;
import org.raphets.android.base.BaseApplication;

/**
 * @文件名称：ToastUitl
 * @文件描述：ToastUitl工具类
 */
public class ToastUitl {


    private static Toast toast;

    private static void showToast(CharSequence message, int duration) {
        Context context = ActivityUtils.getInstance().getCurrentActivity();
        if (toast == null) {
            toast = new Toast(context);
        }
        //LayoutInflater的作用：对于一个没有被载入或者想要动态载入的界面，都需要LayoutInflater.inflate()来载入，
        // LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();//调用Activity的getLayoutInflater()
        View view = inflater.inflate(R.layout.layout_toast_view, null); //加載layout下的布局
        AppCompatTextView tvMessage = view.findViewById(R.id.tv_layout_toast_message);
        tvMessage.setText(message); //toast内容
        toast.setGravity(Gravity.CENTER, 0, 0);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
        toast.setDuration(duration);//setDuration方法：设置持续时间，以毫秒为单位。该方法是设置补间动画时间长度的主要方法
        toast.setView(view); //添加视图文件
        toast.show();
    }

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message) {
        showToast(message, Toast.LENGTH_SHORT);
}


    /**
     * 短时间显示Toast
     *
     * @param strResId
     */
    public static void showShort(int strResId) {
        showToast(BaseApplication.getInstance().getResources().getText(strResId), Toast.LENGTH_SHORT);
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(CharSequence message) {
        showToast(message, Toast.LENGTH_LONG);
    }

    /**
     * 长时间显示Toast
     *
     * @param strResId
     */
    public static void showLong(int strResId) {
        showToast(BaseApplication.getInstance().getResources().getText(strResId), Toast.LENGTH_LONG);
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        showToast(message, duration);
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param strResId
     * @param duration
     */
    public static void show(Context context, int strResId, int duration) {
        showToast(context.getResources().getText(strResId), duration);
    }

    public static void cancelToast(){
        if (toast != null){
            toast.cancel();
        }
    }
}
