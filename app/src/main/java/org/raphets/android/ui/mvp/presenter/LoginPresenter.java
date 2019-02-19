package org.raphets.android.ui.mvp.presenter;

import android.util.Log;

import com.orhanobut.logger.Logger;

import org.raphets.android.base.BaseApplication;
import org.raphets.android.base.BaseObserver;
import org.raphets.android.http.RetrofitHelper;
import org.raphets.android.http.api.ApiService;
import org.raphets.android.ui.mvp.contract.LoginContract;
import org.raphets.android.ui.mvp.model.LoginResult;
import org.raphets.android.utils.FastJsonTools;
import org.raphets.android.utils.HashMapBeanTools;
import org.reactivestreams.Subscriber;

import java.util.WeakHashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(Object msg) {

        RetrofitHelper.getInstance()
                .create(ApiService.class)
                .login(HashMapBeanTools.Obj2Map(msg))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LoginResult>() {
                    @Override
                    public void callBack(LoginResult response) {
//                        Logger.i(response.toString());
                    }
                });

    }
}
