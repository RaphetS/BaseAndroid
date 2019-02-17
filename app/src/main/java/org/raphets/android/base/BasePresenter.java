
/*
 * ***************************************************************************
 *
 * Copyright (c) 2018.
 * 武汉美美咖科技有限公司版权所有
 * File Last Modified 18-3-9 上午11:39
 * OLD MAN CO.. LTD. ALL RIGHTS RESERVED.
 *  *
 *  ***************************************************************************
 */

package org.raphets.android.base;
import android.content.Context;


import org.raphets.android.utils.ToastUitl;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @文件名称：BasePresenter
 * @文件作者：柯雄枫
 * @时间：2018/3/10/010 11:13
 * @邮箱：915611039@qq.com
 * @文件描述：BasePresenter基类
 */
public  abstract class BasePresenter<T,E> {
    public E mModel;
    public T mView;
    public Context mContext;

    public void setVM(T v,Context  context, E m) {
        this.mView = v;
        this.mContext =context;
        this.mModel = m;
    }


}

