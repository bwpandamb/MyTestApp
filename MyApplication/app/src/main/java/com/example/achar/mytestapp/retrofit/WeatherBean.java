package com.example.achar.mytestapp.retrofit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ext.charles.ma on 17/7/24.
 */

public class WeatherBean {

    private List<HeWeather5Bean> HeWeather5;


    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Bean {
        /**
         * aqi : {"city":{"aqi":"39","co":"1","no2":"27","o3":"46","pm10":"37","pm25":"27","qlty":"优","so2":"2"}}
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.90498734","lon":"116.40528870","update":{"loc":"2017-07-24 15:47","utc":"2017-07-24 07:47"}}
         * daily_forecast : [{"astro":{"mr":"05:50","ms":"20:13","sr":"05:07","ss":"19:35"},"cond":{"code_d":"104","code_n":"300","txt_d":"阴","txt_n":"阵雨"},"date":"2017-07-24","hum":"61","pcpn":"1.4","pop":"17","pres":"1006","tmp":{"max":"29","min":"23"},"uv":"6","vis":"16","wind":{"deg":"285","dir":"西北风","sc":"微风","spd":"6"}},{"astro":{"mr":"06:59","ms":"20:55","sr":"05:08","ss":"19:34"},"cond":{"code_d":"104","code_n":"104","txt_d":"阴","txt_n":"阴"},"date":"2017-07-25","hum":"47","pcpn":"0.1","pop":"87","pres":"1008","tmp":{"max":"28","min":"22"},"uv":"6","vis":"18","wind":{"deg":"186","dir":"南风","sc":"微风","spd":"4"}},{"astro":{"mr":"08:07","ms":"21:31","sr":"05:09","ss":"19:33"},"cond":{"code_d":"306","code_n":"300","txt_d":"中雨","txt_n":"阵雨"},"date":"2017-07-26","hum":"54","pcpn":"2.2","pop":"99","pres":"1007","tmp":{"max":"24","min":"20"},"uv":"1","vis":"16","wind":{"deg":"181","dir":"南风","sc":"微风","spd":"5"}}]
         * hourly_forecast : [{"cond":{"code":"305","txt":"小雨"},"date":"2017-07-24 16:00","hum":"61","pop":"17","pres":"1003","tmp":"27","wind":{"deg":"168","dir":"东南风","sc":"微风","spd":"5"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-07-24 19:00","hum":"60","pop":"1","pres":"1004","tmp":"26","wind":{"deg":"196","dir":"西南风","sc":"微风","spd":"3"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-07-24 22:00","hum":"57","pop":"0","pres":"1007","tmp":"25","wind":{"deg":"218","dir":"西南风","sc":"微风","spd":"2"}}]
         * now : {"cond":{"code":"104","txt":"阴"},"fl":"32","hum":"63","pcpn":"0","pres":"1004","tmp":"30","vis":"10","wind":{"deg":"11","dir":"东北风","sc":"微风","spd":"9"}}
         * status : ok
         * suggestion : {"comf":{"brf":"较舒适","txt":"白天以阴或多云天气为主，但稍会让您感到有点儿热，但大部分人完全可以接受。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"sport":{"brf":"较不宜","txt":"阴天，且天气较热，请减少运动时间并降低运动强度。"},"trav":{"brf":"适宜","txt":"天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。"},"uv":{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}}
         */

        private AqiBean aqi;
        private String status;
        private SuggestionBean suggestion;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyForecastBean> hourly_forecast;

        public static HeWeather5Bean objectFromData(String str) {

            return new Gson().fromJson(str, HeWeather5Bean.class);
        }

        public static HeWeather5Bean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), HeWeather5Bean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<HeWeather5Bean> arrayHeWeather5BeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HeWeather5Bean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<HeWeather5Bean> arrayHeWeather5BeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<HeWeather5Bean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }





        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiBean {
            /**
             * city : {"aqi":"39","co":"1","no2":"27","o3":"46","pm10":"37","pm25":"27","qlty":"优","so2":"2"}
             */


            public static AqiBean objectFromData(String str) {

                return new Gson().fromJson(str, AqiBean.class);
            }

            public static AqiBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), AqiBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<AqiBean> arrayAqiBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AqiBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<AqiBean> arrayAqiBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<AqiBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

        }





        public static class SuggestionBean {
            /**
             * comf : {"brf":"较舒适","txt":"白天以阴或多云天气为主，但稍会让您感到有点儿热，但大部分人完全可以接受。"}
             * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
             * drsg : {"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"}
             * flu : {"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
             * sport : {"brf":"较不宜","txt":"阴天，且天气较热，请减少运动时间并降低运动强度。"}
             * trav : {"brf":"适宜","txt":"天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。"}
             * uv : {"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
             */

            private ComfBean comf;
            private CwBean cw;
            private DrsgBean drsg;
            private FluBean flu;
            private SportBean sport;
            private TravBean trav;
            private UvBean uv;

            public static SuggestionBean objectFromData(String str) {

                return new Gson().fromJson(str, SuggestionBean.class);
            }

            public static SuggestionBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), SuggestionBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<SuggestionBean> arraySuggestionBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SuggestionBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<SuggestionBean> arraySuggestionBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<SuggestionBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public static class ComfBean {
                /**
                 * brf : 较舒适
                 * txt : 白天以阴或多云天气为主，但稍会让您感到有点儿热，但大部分人完全可以接受。
                 */

                private String brf;
                private String txt;

                public static ComfBean objectFromData(String str) {

                    return new Gson().fromJson(str, ComfBean.class);
                }

                public static ComfBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ComfBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ComfBean> arrayComfBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ComfBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ComfBean> arrayComfBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ComfBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwBean {
                /**
                 * brf : 不宜
                 * txt : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
                 */

                private String brf;
                private String txt;

                public static CwBean objectFromData(String str) {

                    return new Gson().fromJson(str, CwBean.class);
                }

                public static CwBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), CwBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<CwBean> arrayCwBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CwBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<CwBean> arrayCwBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<CwBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgBean {
                /**
                 * brf : 热
                 * txt : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
                 */

                private String brf;
                private String txt;

                public static DrsgBean objectFromData(String str) {

                    return new Gson().fromJson(str, DrsgBean.class);
                }

                public static DrsgBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), DrsgBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<DrsgBean> arrayDrsgBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<DrsgBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<DrsgBean> arrayDrsgBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<DrsgBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluBean {
                /**
                 * brf : 少发
                 * txt : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
                 */

                private String brf;
                private String txt;

                public static FluBean objectFromData(String str) {

                    return new Gson().fromJson(str, FluBean.class);
                }

                public static FluBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), FluBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<FluBean> arrayFluBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<FluBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<FluBean> arrayFluBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<FluBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean {
                /**
                 * brf : 较不宜
                 * txt : 阴天，且天气较热，请减少运动时间并降低运动强度。
                 */

                private String brf;
                private String txt;

                public static SportBean objectFromData(String str) {

                    return new Gson().fromJson(str, SportBean.class);
                }

                public static SportBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), SportBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<SportBean> arraySportBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<SportBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<SportBean> arraySportBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<SportBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravBean {
                /**
                 * brf : 适宜
                 * txt : 天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。
                 */

                private String brf;
                private String txt;

                public static TravBean objectFromData(String str) {

                    return new Gson().fromJson(str, TravBean.class);
                }

                public static TravBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), TravBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<TravBean> arrayTravBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<TravBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<TravBean> arrayTravBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<TravBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvBean {
                /**
                 * brf : 弱
                 * txt : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
                 */

                private String brf;
                private String txt;

                public static UvBean objectFromData(String str) {

                    return new Gson().fromJson(str, UvBean.class);
                }

                public static UvBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), UvBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<UvBean> arrayUvBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<UvBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<UvBean> arrayUvBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<UvBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * astro : {"mr":"05:50","ms":"20:13","sr":"05:07","ss":"19:35"}
             * cond : {"code_d":"104","code_n":"300","txt_d":"阴","txt_n":"阵雨"}
             * date : 2017-07-24
             * hum : 61
             * pcpn : 1.4
             * pop : 17
             * pres : 1006
             * tmp : {"max":"29","min":"23"}
             * uv : 6
             * vis : 16
             * wind : {"deg":"285","dir":"西北风","sc":"微风","spd":"6"}
             */

            private AstroBean astro;
            private CondBeanX cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String uv;
            private String vis;
            private WindBeanX wind;

            public static DailyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, DailyForecastBean.class);
            }

            public static DailyForecastBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), DailyForecastBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<DailyForecastBean> arrayDailyForecastBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DailyForecastBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<DailyForecastBean> arrayDailyForecastBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<DailyForecastBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBeanX getWind() {
                return wind;
            }

            public void setWind(WindBeanX wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                /**
                 * mr : 05:50
                 * ms : 20:13
                 * sr : 05:07
                 * ss : 19:35
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public static AstroBean objectFromData(String str) {

                    return new Gson().fromJson(str, AstroBean.class);
                }

                public static AstroBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), AstroBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<AstroBean> arrayAstroBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<AstroBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<AstroBean> arrayAstroBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<AstroBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBeanX {
                /**
                 * code_d : 104
                 * code_n : 300
                 * txt_d : 阴
                 * txt_n : 阵雨
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public static CondBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, CondBeanX.class);
                }

                public static CondBeanX objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), CondBeanX.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<CondBeanX> arrayCondBeanXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CondBeanX>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<CondBeanX> arrayCondBeanXFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<CondBeanX>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean {
                /**
                 * max : 29
                 * min : 23
                 */

                private String max;
                private String min;

                public static TmpBean objectFromData(String str) {

                    return new Gson().fromJson(str, TmpBean.class);
                }

                public static TmpBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), TmpBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<TmpBean> arrayTmpBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<TmpBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<TmpBean> arrayTmpBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<TmpBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindBeanX {
                /**
                 * deg : 285
                 * dir : 西北风
                 * sc : 微风
                 * spd : 6
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, WindBeanX.class);
                }

                public static WindBeanX objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), WindBeanX.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<WindBeanX> arrayWindBeanXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBeanX>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<WindBeanX> arrayWindBeanXFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<WindBeanX>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastBean {
            /**
             * cond : {"code":"305","txt":"小雨"}
             * date : 2017-07-24 16:00
             * hum : 61
             * pop : 17
             * pres : 1003
             * tmp : 27
             * wind : {"deg":"168","dir":"东南风","sc":"微风","spd":"5"}
             */

            private CondBeanXX cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private WindBeanXX wind;

            public static HourlyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, HourlyForecastBean.class);
            }

            public static HourlyForecastBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), HourlyForecastBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<HourlyForecastBean> arrayHourlyForecastBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<HourlyForecastBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<HourlyForecastBean> arrayHourlyForecastBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<HourlyForecastBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public CondBeanXX getCond() {
                return cond;
            }

            public void setCond(CondBeanXX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindBeanXX getWind() {
                return wind;
            }

            public void setWind(WindBeanXX wind) {
                this.wind = wind;
            }

            public static class CondBeanXX {
                /**
                 * code : 305
                 * txt : 小雨
                 */

                private String code;
                private String txt;

                public static CondBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, CondBeanXX.class);
                }

                public static CondBeanXX objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), CondBeanXX.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<CondBeanXX> arrayCondBeanXXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CondBeanXX>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<CondBeanXX> arrayCondBeanXXFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<CondBeanXX>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBeanXX {
                /**
                 * deg : 168
                 * dir : 东南风
                 * sc : 微风
                 * spd : 5
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, WindBeanXX.class);
                }

                public static WindBeanXX objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), WindBeanXX.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<WindBeanXX> arrayWindBeanXXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBeanXX>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<WindBeanXX> arrayWindBeanXXFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<WindBeanXX>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}
