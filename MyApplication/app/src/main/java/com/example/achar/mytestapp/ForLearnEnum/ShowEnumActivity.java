package com.example.achar.mytestapp.ForLearnEnum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.achar.mytestapp.R;

public class ShowEnumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_enmu);


        EntityForPast pastEntity = new EntityForPast();
        pastEntity.setType(EntityForPast.AUDIO);
        pastEntity.setType(0);

        EntityForEnum enmuEntity = new EntityForEnum();
        enmuEntity.setType(TypeEnum.AUDIO);


        TypeEnum audio = TypeEnum.TEXT;

        System.out.println("mbmb" + audio.getValue());
        System.out.println("mbmb" + audio.getName());
        System.out.println("mbmb" + audio.getByValue(1));



    }
}
