package com.example.lenovo.geeknews.model.http.api;

import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ZhihuApiServer {

    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<RiBaoBean> getRiBao();

    /**
     * 专栏日报
     */
    @GET("sections")
    Observable<ZhuanLanBean> getZhuanLan();

    /**
     * 热门日报
     */
    @GET("news/hot")
    Observable<HotBean> getHot();

    @GET("news/{news_id}")
    Observable<RIBaoXiang> getXiang(@Path("news_id") String id);

//    http://news-at.zhihu.com/api/4/news/before/20190419

    @GET()
    Observable<DateBean> getDate(@Url String date);
}
