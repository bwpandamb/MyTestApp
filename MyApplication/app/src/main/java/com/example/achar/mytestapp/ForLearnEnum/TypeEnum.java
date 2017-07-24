package com.example.achar.mytestapp.ForLearnEnum;

/**
 * Created by ext.charles.ma on 17/7/24.
 */

public enum TypeEnum {
    VIDEO(0,"音频"), AUDIO(1,"声频"), TEXT(2,"文本"), IMAGE(3,"图片");

    int value;
    String name;

    TypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public TypeEnum getByValue(int value) {
        for(TypeEnum typeEnum : TypeEnum.values()) {
            if(typeEnum.value == value) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }
}
