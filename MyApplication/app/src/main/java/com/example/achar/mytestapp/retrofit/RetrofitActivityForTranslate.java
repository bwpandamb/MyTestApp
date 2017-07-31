package com.example.achar.mytestapp.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.achar.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 这个界面，我记录了两个翻译用的API，可以用来调试retrofit
 * 同时我还记录了一个java的有趣的题目，和integer的cache有关
 */
public class RetrofitActivityForTranslate extends AppCompatActivity {

    @BindView(R.id.btnR1)
    Button btnR1;
    @BindView(R.id.btnR2)
    Button btnR2;
    @BindView(R.id.btnR3)
    Button btnR3;
    @BindView(R.id.btnR4)
    Button btnR4;
    @BindView(R.id.btnR5)
    Button btnR5;
    @BindView(R.id.textView)
    TextView textView;
    private String BaseUrlForPost = "http://fanyi.youdao.com/";
    private String BaseUrlForGet = "http://fy.iciba.com/";
    private TranslateApi translateApi;
    private TranslateApi translateApiGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_for_translate);
        ButterKnife.bind(this);


        Retrofit builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseUrlForPost)
                .build();

        Retrofit builderGet = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseUrlForGet)
                .build();

        translateApi = builder.create(TranslateApi.class);

        translateApiGet = builderGet.create(TranslateApi.class);





    }

    private void getRequest() {
        Call<TranslateGetBean> call2 = translateApiGet.getCall2();
        call2.enqueue(new Callback<TranslateGetBean>() {
            @Override
            public void onResponse(Call<TranslateGetBean> call, Response<TranslateGetBean> response) {
                System.out.println("翻译的结果：" + response.body().getContent().getOut());
                textView.setText("翻译的结果：" + response.body().getContent().getOut());
            }

            @Override
            public void onFailure(Call<TranslateGetBean> call, Throwable t) {
                Log.e("mbmb", "失败了" + t.getMessage());
            }
        });
    }

    private void postRequest() {
        Call<TranslatePostBean> call = translateApi.getCall("It is my life");

        call.enqueue(new Callback<TranslatePostBean>() {
            @Override
            public void onResponse(Call<TranslatePostBean> call, Response<TranslatePostBean> response) {
                System.out.println("翻译的结果：" + response.body().getTranslateResult().get(0).get(0).getTgt());
                textView.setText("翻译的结果：" + response.body().getTranslateResult().get(0).get(0).getTgt());

            }

            @Override
            public void onFailure(Call<TranslatePostBean> call, Throwable t) {
                Log.e("mbmb", "失败了" + t.getMessage());
            }
        });
    }

    @OnClick({R.id.btnR1, R.id.btnR2, R.id.btnR3, R.id.btnR4, R.id.btnR5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnR1:
                postRequest();
                break;
            case R.id.btnR2:
                getRequest();
                break;
            case R.id.btnR3:
                Integer i1 = 127,i2 = 127;
                System.out.println(i1 == i2);

                i1 = 128;
                i2 = 128;

                System.out.println(i1 == i2);


                break;
            case R.id.btnR4:
                break;
            case R.id.btnR5:
                break;
        }
    }
}
