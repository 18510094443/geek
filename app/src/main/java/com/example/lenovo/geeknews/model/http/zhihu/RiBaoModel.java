package com.example.lenovo.geeknews.model.http.zhihu;

import com.example.lenovo.geeknews.base.BaseObServer;
import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;
import com.example.lenovo.geeknews.model.http.HttpFinishCallBack;
import com.example.lenovo.geeknews.model.http.HttpManger;
import com.example.lenovo.geeknews.utils.RxUtils;

public class RiBaoModel {

    public interface ZhihuFinish extends HttpFinishCallBack{
        void getRiBao(RiBaoBean riBaoBean);
        void getZhuanlan(ZhuanLanBean zhuanLanBean);

        void getHot(HotBean hotBean);

        void getXiang(RIBaoXiang xiang);

        void getDate(DateBean dateBean);
    }

    public void getRiBao(final ZhihuFinish zhihuFinish){
        zhihuFinish.showProgress();
        HttpManger.getZhihuApiServer().getRiBao().compose(RxUtils.<RiBaoBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(zhihuFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        zhihuFinish.getRiBao((RiBaoBean) o);
                    }
                });
    }

    public void getZhuanlan(final ZhihuFinish zhihuFinish){
        zhihuFinish.showProgress();
        HttpManger.getZhihuApiServer().getZhuanLan().compose(RxUtils.<ZhuanLanBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(zhihuFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        zhihuFinish.getZhuanlan((ZhuanLanBean) o);
                    }
                });
    }

    public void getHot(final ZhihuFinish zhihuFinish){
        zhihuFinish.showProgress();
        HttpManger.getZhihuApiServer().getHot().compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(zhihuFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        zhihuFinish.getHot((HotBean) o);
                    }
                });
    }

    public void getXiang(final ZhihuFinish zhihuFinish,String id){
        zhihuFinish.showProgress();
        HttpManger.getZhihuApiServer().getXiang(id).compose(RxUtils.<RIBaoXiang>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(zhihuFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        zhihuFinish.getXiang((RIBaoXiang) o);
                    }
                });
    }

    public void getDate(final ZhihuFinish zhihuFinish,String date){
        zhihuFinish.showProgress();
        HttpManger.getZhihuApiServer().getDate(date).compose(RxUtils.<DateBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(zhihuFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        zhihuFinish.getDate((DateBean) o);
                    }
                });
    }


}
