package com.example.lenovo.geeknews.model.http.api;




import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;
import com.example.lenovo.geeknews.model.bean.weixin.TabBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WeiXinApis {
    String URL="http://api.tianapi.com/";


    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Observable<FragmentBean> getWeChat(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Observable<FragmentBean> getWord(@Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);
}
