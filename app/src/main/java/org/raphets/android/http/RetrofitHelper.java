package org.raphets.android.http;



import org.raphets.android.Constants.HttpConstant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 */
public class RetrofitHelper {

    private static Retrofit mRetrofit;
    private static RetrofitHelper instance;


    private RetrofitHelper(){

        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitHelper getInstance(){
       if (instance==null){
           synchronized (RetrofitHelper.class){
               if (instance==null){
                   instance=new RetrofitHelper();
               }
           }
       }
        return instance;
    }

    public Retrofit getRetrofit(){
        if (mRetrofit==null){
            new RetrofitHelper();
        }
        return mRetrofit;
    }

    /**
     * 根据Api接口类生成Api实体
     *
     * @param clazz 传入的Api接口类
     * @return Api实体类
     */
    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

}
