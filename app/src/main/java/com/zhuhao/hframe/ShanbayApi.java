package com.zhuhao.hframe;

import com.zhuhao.hframe.ResponseEntity.LoginEntity;

import cn.henryzhuhao.mainframe.net.BaseResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author : zhuhao
 * Date : 3/9/2017
 *
 * @Last Modified Time :3/9/2017
 * Description :
 */

public interface ShanbayApi {
    @FormUrlEncoded
    @POST("login")
    Observable<BaseResponse<LoginEntity>> login(@Field("userName") String userName, @Field("password") String password);
}
