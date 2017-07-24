package com.example.achar.mytestapp.ForLearnEnum;

/**
 * Created by ext.charles.ma on 17/7/24.
 */

public class EntityForPast {

    public static final int VIDEO = 1;//视频
    public static final int AUDIO = 2;//音频
    public static final int TEXT = 3;//文字
    public static final int IMAGE = 4;//图片


    private int id;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
