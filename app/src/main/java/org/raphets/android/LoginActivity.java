package org.raphets.android;

import android.text.TextUtils;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import org.raphets.android.base.BaseActivity;
import org.raphets.android.ui.mvp.contract.LoginContract;
import org.raphets.android.ui.mvp.model.LoginResult;
import org.raphets.android.ui.mvp.model.request.LoginRequest;
import org.raphets.android.ui.mvp.presenter.LoginPresenter;

import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter>
        implements LoginContract.View {
    @BindView(R.id.et_username)
    AppCompatEditText mEtUsername;

    @BindView(R.id.et_password)
    AppCompatEditText mEtPassword;

    @BindView(R.id.btn_login)
    Button mBtnLogin;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate() {

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,this);
    }

    @Override
    public void loginResult(Object result) {
        LoginResult loginResult = (LoginResult) result;
        Logger.i(loginResult.toString());
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username)){
            return;
        }
        if (TextUtils.isEmpty(password)){
            return;
        }

        LoginRequest request = new LoginRequest();
        request.setUsername(username);
        request.setPassword(password);
//        request.setMode(2);

        mPresenter.login(request);

    }
}
