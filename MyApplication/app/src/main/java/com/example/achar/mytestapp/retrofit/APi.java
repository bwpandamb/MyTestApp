package com.example.achar.mytestapp.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APi {

    @GET("weather")
    Call<WeatherBean> getString(@Query("city") String city, @Query("key")String key);

    @GET("weather")
    Call<String> getStringByJson(@Query("city") String city, @Query("key")String key);

    @FormUrlEncoded
    @POST("weather")
    Call<WeatherBean> getByPost(@Field("city") String city,@Field("key") String key);

    @POST("weather")
    Call<WeatherBean> getByPostNoForm(@Query("city") String city,@Query("key") String key);


    //很明显这种形式行不通，在retrofit2.0之后，都需要一个call来承载这个对象
//    @GET("weather")
//    WeatherBean getBeanD(@Query("city") String city, @Query("key")String key);
}
