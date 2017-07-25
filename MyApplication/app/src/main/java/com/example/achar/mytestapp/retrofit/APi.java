package com.example.achar.mytestapp.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APi {

    @GET("weather")
    Call<WeatherBean> getString(@Query("city") String city, @Query("key")String key);

    @GET("weather")
    Call<String> getStringByJson(@Query("city") String city, @Query("key")String key);
}
