package org.raphets.android.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.JsonParseException;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import org.raphets.android.utils.FastJsonTools;
import org.raphets.android.utils.ProgressDialogUtil;
import org.raphets.android.utils.ToastUitl;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * @author ：mp5a5 on 2018/12/28 13：52
 * @describe： 网络状态的封装类，子类初始化该类后，必须重写onSuccess(response)方法，可以选择性的重写onFailing(response)
 * @email：wwb199055@126.com
 */

public abstract class BaseObserver<T> implements Observer<T> {
    /**
     * dialog 显示文字
     */
    private String mMsg;
    private Context mContext;
    private boolean mShowLoading = false;

    private static final String CONNECT_ERROR = "网络连接失败,请检查网络";
    private static final String CONNECT_TIMEOUT = "连接超时,请稍后再试";
    private static final String BAD_NETWORK = "服务器异常";
    private static final String PARSE_ERROR = "解析服务器响应数据失败";
    private static final String UNKNOWN_ERROR = "未知错误";

    public BaseObserver() {
    }

    /**
     * 如果传入上下文，那么表示您将开启自定义的进度条
     *
     * @param context 上下文
     */
    public BaseObserver(Context context, boolean isShow) {
        this.mContext = context;
        this.mShowLoading = isShow;
    }

    /**
     * 如果传入上下文，那么表示您将开启自定义的进度条
     *
     * @param context 上下文
     */
    public BaseObserver(Context context, boolean isShow, String msg) {
        this.mContext = context;
        this.mShowLoading = isShow;
        this.mMsg = msg;
    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onNext(T response) {
        onRequestEnd();
        //打印结果日志
        Logger.json(FastJsonTools.bean2Json(response));

        callBack(response);
    }

    @Override
    public void onError(Throwable e) {
        onRequestEnd();
        Logger.e(e.getMessage());
        if (e instanceof retrofit2.HttpException) {
            //HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
            //连接错误
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //连接超时
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            //解析错误
            onException(ExceptionReason.PARSE_ERROR);
        } else {
            //其他错误
            onException(ExceptionReason.UNKNOWN_ERROR);
        }
    }

    private void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUitl.showShort(CONNECT_ERROR);
                break;

            case CONNECT_TIMEOUT:
                ToastUitl.showShort(CONNECT_TIMEOUT);
                break;

            case BAD_NETWORK:
                ToastUitl.showShort(BAD_NETWORK);
                break;

            case PARSE_ERROR:
                ToastUitl.showShort(PARSE_ERROR);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUitl.showShort(UNKNOWN_ERROR);
                break;
        }
    }

    @Override
    public void onComplete() {
        onRequestEnd();
    }

    /**
     * 网络请求失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR
    }

    /**
     * 网络请求开始
     */
    private void onRequestStart() {
        if (mShowLoading) {
            if (TextUtils.isEmpty(mMsg)) {
                ProgressDialogUtil.getInstance().showProgress();
            }else {
                ProgressDialogUtil.getInstance().showProgress(mMsg);
            }
        }
    }

    /**
     * 网络请求结束
     */
    private void onRequestEnd() {
        ProgressDialogUtil.getInstance().dismissProgress();
    }

    public abstract void callBack(T response);
}
