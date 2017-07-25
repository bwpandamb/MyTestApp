package com.example.achar.mytestapp.retrofit;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.btnR1)
    Button btnR1;
    @BindView(R.id.btnR2)
    Button btnR2;
    @BindView(R.id.textView)
    TextView textView;
    private APi mApi;
    String BaseUrl = "https://free-api.heweather.com/v5/";
    private Call<WeatherBean> mApiString;
    private Call<String> stringByJson;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);


        Retrofit retrofit = new Retrofit.Builder()
                //使用自定义的mGsonConverterFactory
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseUrl)
                .build();


        mApi = retrofit.create(APi.class);


        mApiString = mApi.getString("上海", "f9652c29cc334b0889fe270bd9776b94");

        stringByJson = mApi.getStringByJson("上海", "f9652c29cc334b0889fe270bd9776b94");


    }


    @OnClick({R.id.btnR1, R.id.btnR2})
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
        }
    }
}
