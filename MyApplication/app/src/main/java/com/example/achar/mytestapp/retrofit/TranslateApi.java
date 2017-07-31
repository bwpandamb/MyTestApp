package com.example.achar.mytestapp.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ext.charles.ma on 17/7/26.
 */

public interface TranslateApi {

    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    @FormUrlEncoded
    Call<TranslatePostBean> getCall(@Field("i") String targetSentence);


    @GET("ajax.php?a=fy&f=auto&t=auto&w=ok%20ok")
    Call<TranslateGetBean> getCall2();
    // 注解里传入 网络请求 的部分URL地址
    // getCall()是接受网络请求数据的方法

}
