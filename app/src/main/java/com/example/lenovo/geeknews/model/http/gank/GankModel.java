package com.example.lenovo.geeknews.model.http.gank;

import com.example.lenovo.geeknews.base.BaseObServer;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.model.http.HttpFinishCallBack;
import com.example.lenovo.geeknews.model.http.HttpManger;
import com.example.lenovo.geeknews.utils.RxUtils;

public class GankModel {

    public interface GankFInish extends HttpFinishCallBack{
        void getTechList(GankItemBean gankItemBean);
        void getGirlList(GankItemBean gankItemBean);
        void getRandomGirl(GankItemBean gankItemBean);
    }

    public void getTechList(final GankFInish gankFInish, String tech,int num,int page){
        gankFInish.showProgress();
        HttpManger.getGankApis().getTechList(tech,num,page).compose(RxUtils.<GankItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(gankFInish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        gankFInish.getTechList((GankItemBean) o);
                    }
                });
    }

    public void getGirlList(final GankFInish gankFInish,int num,int page){
        gankFInish.showProgress();
        HttpManger.getGankApis().getGirlList(num,page).compose(RxUtils.<GankItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(gankFInish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        gankFInish.getGirlList((GankItemBean) o);
                    }
                });
    }

    public void getRandomGirl(final GankFInish gankFInish,int num){
        gankFInish.showProgress();
        HttpManger.getGankApis().getRandomGirl(num).compose(RxUtils.<GankItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(gankFInish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        gankFInish.getRandomGirl((GankItemBean) o);
                    }
                });
    }

}
