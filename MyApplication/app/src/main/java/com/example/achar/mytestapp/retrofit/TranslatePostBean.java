package com.example.achar.mytestapp.retrofit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ext.charles.ma on 17/7/26.
 */

public class TranslatePostBean {

    /**
     * type : asd
     * errorCode : 0
     * translateResult : [[{"src":"aaa","tgt":"asd"}]]
     */

    private String type;
    private int errorCode;
    private List<List<TranslateResultBean>> translateResult;

    public static TranslatePostBean objectFromData(String str) {

        return new Gson().fromJson(str, TranslatePostBean.class);
    }

    public static TranslatePostBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), TranslatePostBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<TranslatePostBean> arrayTranslatePostFromData(String str) {

        Type listType = new TypeToken<ArrayList<TranslatePostBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<TranslatePostBean> arrayTranslatePostFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<TranslatePostBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<List<TranslateResultBean>> getTranslateResult() {
        return translateResult;
    }

    public void setTranslateResult(List<List<TranslateResultBean>> translateResult) {
        this.translateResult = translateResult;
    }

    public static class TranslateResultBean {
        /**
         * src : aaa
         * tgt : asd
         */

        private String src;
        private String tgt;

        public static TranslateResultBean objectFromData(String str) {

            return new Gson().fromJson(str, TranslateResultBean.class);
        }

        public static TranslateResultBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), TranslateResultBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TranslateResultBean> arrayTranslateResultBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TranslateResultBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TranslateResultBean> arrayTranslateResultBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TranslateResultBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTgt() {
            return tgt;
        }

        public void setTgt(String tgt) {
            this.tgt = tgt;
        }
    }
}
