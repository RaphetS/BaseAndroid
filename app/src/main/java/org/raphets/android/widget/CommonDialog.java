package org.raphets.android.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.raphets.android.R;
import org.raphets.android.base.BaseDialog;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonDialog extends BaseDialog {
    @BindView(R.id.tv_tile_common_dialog)
    TextView mTvTile;
    @BindView(R.id.tv_message_common_dialog)
    TextView mTvMessage;
    @BindView(R.id.tv_cancle_common_dialog)
    TextView mTvCancle;
    @BindView(R.id.tv_ok_common_dialog)
    TextView mTvOk;

    private String mTite;
    private String mMessage;
    private String mOkStr;
    private String mCancelStr;
    private OnOkClickListener mListener;

    public CommonDialog(@NonNull Context context, String title, String message, OnOkClickListener listener) {
        super(context);
        mTite = title;
        mMessage = message;
        mListener = listener;
    }
    public CommonDialog(@NonNull Context context, String title, String message, String btnOk, String btnCancel, OnOkClickListener listener) {
        super(context);
        mTite = title;
        mMessage = message;
        mOkStr = btnOk;
        mCancelStr = btnCancel;
        mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_common);
        ButterKnife.bind(this);

        initUI();

        addListener();

    }

    private void addListener() {
        mTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.onClick();
                }
                cancel();
            }
        });
        mTvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }

    private void initUI() {
        mTvTile.setText(mTite);
        mTvMessage.setText(mMessage);
        if (!TextUtils.isEmpty(mOkStr)){
            mTvOk.setText(mOkStr);
        }
        if (!TextUtils.isEmpty(mCancelStr)){
            mTvCancle.setText(mCancelStr);
        }
    }



    public interface OnOkClickListener{
        void onClick();
    }
}
