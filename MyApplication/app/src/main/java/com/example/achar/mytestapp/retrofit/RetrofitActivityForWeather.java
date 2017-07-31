package com.example.achar.mytestapp.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.achar.mytestapp.R;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 这个类用来测试和记录一个关于天气的API，同时有关于retrofit的一些用法
 *
 *
 *
 */
public class RetrofitActivityForWeather extends AppCompatActivity {

    @BindView(R.id.btnR1)
    Button btnR1;
    @BindView(R.id.btnR2)
    Button btnR2;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.btnR3)
    Button btnR3;
    @BindView(R.id.btnR4)
    Button btnR4;
    @BindView(R.id.btnR5)
    Button btnR5;
    private APi mApi;
    String BaseUrl = "https://free-api.heweather.com/v5/";
    private Call<WeatherBean> mApiString;
    private Call<String> stringByJson;

    Gson gson = new Gson();
    private Call<WeatherBean> byPostApi;
    private Call<WeatherBean> byPostNoForm;
    private WeatherBean beanD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        OkHttpClient client = new OkHttpClient();

        //
        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseUrl)
                .client(client)
                .build();


        mApi = retrofit.create(APi.class);


        mApiString = mApi.getString("上海", "f9652c29cc334b0889fe270bd9776b94");

        stringByJson = mApi.getStringByJson("上海", "f9652c29cc334b0889fe270bd9776b94");

        byPostApi = mApi.getByPost("上海", "f9652c29cc334b0889fe270bd9776b94");

        byPostNoForm = mApi.getByPostNoForm("上海", "f9652c29cc334b0889fe270bd9776b94");

//        beanD = mApi.getBeanD("上海", "f9652c29cc334b0889fe270bd9776b94");


    }


    @OnClick({R.id.btnR1, R.id.btnR2, R.id.btnR3, R.id.btnR4,R.id.btnR5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnR1:
                mApiString.clone().enqueue(new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        Log.e("MB", "成功了");
                        WeatherBean body = response.body();
                        String txt = body.getHeWeather5().get(0).getSuggestion().getComf().getTxt();
                        textView.setText(txt);

                        Log.e("MB", "" + txt); //我打印其中一段内容来保证我确实是正确的拿到了这个请求的内容
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        Log.e("MB", "失败了");
                    }
                });

                break;

            case R.id.btnR2:
                stringByJson.clone().enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        String body = response.body();
                        WeatherBean bean = gson.fromJson(body, WeatherBean.class);
                        textView.setText(body);

                        Log.e("MB", "成功了" + response.body());
                        Log.e("MB", "成功了" + bean.getHeWeather5().get(0).getSuggestion().getComf().getTxt());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("MB", "失败了" + t.getMessage());
                    }
                });
                break;

            case R.id.btnR3:
                byPostApi.clone().enqueue(new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        Log.e("MB", "成功了" + response.body().getHeWeather5().get(0).getSuggestion().getComf().getTxt());
                        textView.setText(response.body().getHeWeather5().get(0).getSuggestion().getComf().getTxt());
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        Log.e("MB", "失败了" + t.getMessage());
                        textView.setText(t.getMessage());
                    }
                });

                break;

            case R.id.btnR4:
                byPostNoForm.clone().enqueue(new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        Log.e("MB", "成功了" + response.body().getHeWeather5().get(0).getSuggestion().getCw().getTxt());
                        textView.setText(response.body().getHeWeather5().get(0).getSuggestion().getCw().getTxt());
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        Log.e("MB", "失败了" + t.getMessage());
                        textView.setText(t.getMessage());
                    }
                });

                break;
            case R.id.btnR5:
                startActivity(new Intent(RetrofitActivityForWeather.this,RetrofitActivityForTranslate.class));

                break;
        }
    }
}
