package com.example.achar.mytestapp.ClickForLocalPhoto;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.achar.mytestapp.R;

/**
 * 这里Activity用来展示那个点击进入本地相册拿到图片设置在手机上的功能
 *
 * 现在暂时是只能拿本地图片啦，我打算加上调用相机，裁剪，处理图片资源大小，等功能
 */
public class ClickForCarmeraActivity extends AppCompatActivity {

    private ImageView iv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_for_carmera);

        btn = (Button) findViewById(R.id.btn);
        iv = (ImageView) findViewById(R.id.iv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();

            //可以选择这样直接设置图片
            iv.setImageURI(data.getData());

            //也可以这样把图片通过流和内容解析者转化为bitmap
//                try {
//                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//                    if (bitmap != null) {
//                        iv.setImageBitmap(bitmap);
//
////                        iv.setImageURI(data.getData());
////                    }
//                    /* 将Bitmap设定到ImageView */
//                    }
//                } catch (FileNotFoundException e) {
//                    Log.e("Exception", e.getMessage(),e);
//                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
