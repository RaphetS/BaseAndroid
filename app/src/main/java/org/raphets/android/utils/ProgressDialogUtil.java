package org.raphets.android.utils;

import android.app.Activity;
import android.content.Context;

import org.raphets.android.widget.CustomProgressDialog;

public class ProgressDialogUtil {

    private static ProgressDialogUtil instance;
    private CustomProgressDialog mProgressDialog;

    private ProgressDialogUtil() {

    }

    public static ProgressDialogUtil getInstance(){
        if (instance==null){
            synchronized (ProgressDialogUtil.class){
                if (instance==null){
                    instance=new ProgressDialogUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 显示ProgressDialog
     */
    public void showProgress() {
        Activity activity = ActivityUtils.getInstance().getCurrentActivity();
        if (mProgressDialog == null) {
            mProgressDialog = new CustomProgressDialog(activity);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 显示ProgressDialog
     */
    public void showProgress(String message) {
        Activity activity = ActivityUtils.getInstance().getCurrentActivity();
        if (mProgressDialog == null) {
            mProgressDialog = new CustomProgressDialog(activity,message);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }


    /**
     * 取消ProgressDialog
     */
    public void dismissProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog.cancel();
            mProgressDialog=null;
        }
    }
}
