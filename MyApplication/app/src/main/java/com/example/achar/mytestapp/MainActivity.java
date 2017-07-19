package com.example.achar.mytestapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
