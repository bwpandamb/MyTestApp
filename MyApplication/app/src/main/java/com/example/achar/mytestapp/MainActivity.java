package com.example.achar.mytestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.achar.mytestapp.ClickForLocalPhoto.ClickForCarmeraActivity;
import com.example.achar.mytestapp.ForLearnEnum.ShowEnumActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn1.setText("图片获取与设置");
        btn2.setText("枚举");


    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivityByAcitvityName(ClickForCarmeraActivity.class);
                break;
            case R.id.btn2:
                startActivityByAcitvityName(ShowEnumActivity.class);
                break;
            case R.id.btn3:

                break;
            case R.id.btn4:
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
        }
    }

    private void startActivityByAcitvityName(Class<?> className) {
        Intent intent = new Intent(MainActivity.this, className);
        startActivity(intent);
    }

}
