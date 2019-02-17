/*
 * ***************************************************************************
 *
 * Copyright (c) 2018.
 * 武汉美美咖科技有限公司版权所有
 * File Last Modified 17-11-2 上午11:28
 * OLD MAN CO.. LTD. ALL RIGHTS RESERVED.
 *  *
 *  ***************************************************************************
 */

package org.raphets.android.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * @文件名称：MyActivityManager
 * @文件描述：Activity
 */
public class ActivityUtils {

    private Stack<Activity> activityStack;
    private static ActivityUtils instance;

    private ActivityUtils() {

    }

    public static ActivityUtils getInstance() {
        if (instance == null) {
            instance = new ActivityUtils();
        }
        return instance;
    }


    /**
     * 结束指定类名的Activity
     */
    public void removeActivityFromStack(Class<?> cls) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    activityStack.remove(activity);
                    activity.finish();
                    break;
                }
            }
        }
    }

    public void popActivity(Activity activity){
        if(activity != null){
            if(activityStack != null && activityStack.contains(activity)) {
                activityStack.remove(activity);
            }
            activity.finish();
        }
    }
    
    //关闭当前Activity
    public void popCurretentActivity(){
    	 Activity activity = getCurrentActivity();
         if (activity == null) {
              return ;
         }
         popActivity(activity);
    }
    

    // 获得当前栈顶Acitivity
    public Activity getCurrentActivity() {
        Activity activity = null;
        if (activityStack != null && !activityStack.empty()) {
            activity = (Activity) activityStack.lastElement();
        }
        return activity;
    }

    // 当前Activity推入栈中
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }



    // 退出所有Activity
    public void finishAllActivity() {
        for (Activity activity : activityStack){
            if (activity != null){
                activity.finish();
            }
        }
        activityStack.clear();
    }

}
