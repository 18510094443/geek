package com.example.lenovo.geeknews.model.http;

import com.example.lenovo.geeknews.model.http.api.GankApis;
import com.example.lenovo.geeknews.model.http.api.WeiXinApis;
import com.example.lenovo.geeknews.model.http.api.ZhihuApiServer;

public class HttpManger {

    public static ZhihuApiServer zhihuApiServer;
    public static WeiXinApis weiXinApis;
    public static GankApis gankApis;


    public static ZhihuApiServer getZhihuApiServer(){
        if (zhihuApiServer==null){
            synchronized (ZhihuApiServer.class){
                if (zhihuApiServer==null){
                    zhihuApiServer=HttpUtils.getInstance().getApiserver(ZhihuApiServer.HOST,ZhihuApiServer.class);
                }
            }
        }
        return zhihuApiServer;
    }

    public static WeiXinApis getWeiXinApis(){
        if (weiXinApis==null){
            synchronized (WeiXinApis.class){
                if (weiXinApis==null){
                        weiXinApis=HttpUtils.getInstance().getApiserver(WeiXinApis.URL,WeiXinApis.class);
                }
            }
        }
        return weiXinApis;
    }

    public static GankApis getGankApis(){
        if (gankApis==null){
            synchronized (GankApis.class){
                if (gankApis==null){
                    gankApis=HttpUtils.getInstance().getApiserver(GankApis.HOST,GankApis.class);
                }
            }
        }
        return gankApis;
    }


}
