package org.raphets.android.http.api;

import org.raphets.android.http.BaseResponse;
import org.raphets.android.ui.mvp.model.LoginResult;

import java.util.WeakHashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginResult>> login(@FieldMap WeakHashMap<String, Object> params);
}
