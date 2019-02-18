package org.raphets.android.utils;

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
    public void showProgress(Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new CustomProgressDialog(context);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 显示ProgressDialog
     */
    public void showProgress(Context context,String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new CustomProgressDialog(context,message);
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
