package org.raphets.android.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import org.raphets.android.utils.TUtil;

import java.lang.reflect.Field;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @文件名称：BaseFragment
 * @文件作者：柯雄枫
 * @时间：2018/3/10/010 16:50
 * @邮箱：915611039@qq.com
 * @文件描述：Fragment基类
 */
public abstract  class BaseFragment<T extends BasePresenter> extends Fragment {
    public T mPresenter;
    protected boolean isDetach= true ;
    private Unbinder mUnbinder;
    protected View mRootView;
    protected Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate((int) getLayoutId(), container, false);
        mUnbinder =  ButterKnife.bind(this, mRootView);
        mContext = getActivity();
        mPresenter = TUtil.getT(this, 0);
        if(mPresenter!=null){
            mPresenter.mContext=this.getActivity();
        }
        initPresenter();
        initView();
        return mRootView;
    }




    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        isDetach =false ;
    }

    @Override
    public void onDetach() {
        isDetach = true;
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    //获取布局文件
    protected abstract int getLayoutId();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();
    //初始化view
    protected abstract void initView();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder !=  null) {
            mUnbinder.unbind();
        }
    }

}
