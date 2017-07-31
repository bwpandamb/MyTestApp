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

public class TranslateGetBean {


    /**
     * status : 1
     * content : {"from":"en-us","to":"en-us","vendor":"en-us","out":"en-us","error":0}
     */

    private int status;
    private ContentBean content;

    public static TranslateGetBean objectFromData(String str) {

        return new Gson().fromJson(str, TranslateGetBean.class);
    }

    public static TranslateGetBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), TranslateGetBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<TranslateGetBean> arrayToneFromData(String str) {

        Type listType = new TypeToken<ArrayList<TranslateGetBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<TranslateGetBean> arrayToneFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<TranslateGetBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * from : en-us
         * to : en-us
         * vendor : en-us
         * out : en-us
         * error : 0
         */

        private String from;
        private String to;
        private String vendor;
        private String out;
        private int error;

        public static ContentBean objectFromData(String str) {

            return new Gson().fromJson(str, ContentBean.class);
        }

        public static ContentBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ContentBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ContentBean> arrayContentBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ContentBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ContentBean> arrayContentBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ContentBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }
    }
}
