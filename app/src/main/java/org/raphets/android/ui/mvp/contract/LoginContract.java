package org.raphets.android.ui.mvp.contract;

import org.raphets.android.base.BasePresenter;
import org.raphets.android.base.BaseView;
import org.raphets.android.ui.mvp.model.LoginResult;

import java.util.List;

import io.reactivex.Observable;

public interface LoginContract {

    interface View extends BaseView {
        //登录
        void loginResult(Object result);
    }

    abstract class Presenter extends BasePresenter<View> {
        //获取百科详情
        public abstract void login(Object msg);
    }
}
