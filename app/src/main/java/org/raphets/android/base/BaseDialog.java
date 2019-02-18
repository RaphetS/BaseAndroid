package org.raphets.android.base;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import org.raphets.android.R;
import org.raphets.android.utils.ScreenUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;


/**
 * Created by matou0289 on 2017/1/11.
 */

public class BaseDialog extends AlertDialog {
    protected Context mContext;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Window window=getWindow();
        //点击输入框才能弹出软键盘
        window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width= (int) (ScreenUtil.getScreenWidth(mContext)*0.75);
        window.setAttributes(lp);
    }
}
