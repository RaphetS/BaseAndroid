package org.raphets.android.base;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import io.reactivex.annotations.NonNull;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 */
public class RetrofitHelper {

    public static final String BASE_URL="http://www.yueyeshijia.com/";
    private static Retrofit mRetrofit;
    private static RetrofitHelper instance;
    private final Retrofit.Builder mRetrofitBuilder;


    private RetrofitHelper(){

        mRetrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        mRetrofit = mRetrofitBuilder.build();
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

    /**
     * 根据Api接口类生成Api实体
     *
     * @param baseUrl baseUrl
     * @param clazz   传入的Api接口类
     * @return Api实体类
     */
    public <T> T create(String baseUrl, Class<T> clazz) {
        return mRetrofitBuilder.baseUrl(baseUrl).build().create(clazz);
    }

}
