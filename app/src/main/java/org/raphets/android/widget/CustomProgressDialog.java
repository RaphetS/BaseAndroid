package org.raphets.android.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import org.raphets.android.R;
import org.raphets.android.base.BaseDialog;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;

/**
 * Created by matou0289 on 2017/1/18.
 */

public class CustomProgressDialog extends BaseDialog {

    @BindView(R.id.tv_message_progress_dialog)
    AppCompatTextView mTvMessage;

    private String mMessage;

    public CustomProgressDialog(@NonNull Context context) {
        super(context);
    }

    public CustomProgressDialog(@NonNull Context context,String loadingMessage) {
        super(context);
        mMessage = loadingMessage;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_progress_dialog);
        if (!TextUtils.isEmpty(mMessage)){
            mTvMessage.setVisibility(View.VISIBLE);
            mTvMessage.setText(mMessage);
        }
    }

}
