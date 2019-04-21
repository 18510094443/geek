package com.example.lenovo.geeknews.presenter.zhihu;

import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;
import com.example.lenovo.geeknews.model.http.zhihu.RiBaoModel;
import com.example.lenovo.geeknews.view.zhihu.RIBaoView;

public class ZhiHuPresenter<V extends RIBaoView> extends BasePresenter<V> implements RiBaoModel.ZhihuFinish {

    private RiBaoModel model = new RiBaoModel();

    public void getData(){
        if (model!=null){
            model.getRiBao(this);
            model.getZhuanlan(this);
            model.getHot(this);
        }
    }

    public void getData(String id){
        model.getXiang(this,id);
    }

    public void getData1(String date){
        model.getDate(this,date);
    }

    @Override
    public void getRiBao(RiBaoBean riBaoBean) {
        if (view!=null){
            view.getRiBao(riBaoBean);
        }
    }

    @Override
    public void getZhuanlan(ZhuanLanBean zhuanLanBean) {
        if (view!=null){
            view.getZhuanlan(zhuanLanBean);
        }
    }

    @Override
    public void getHot(HotBean hotBean) {
        if (view!=null){
            view.getHot(hotBean);
        }
    }

    @Override
    public void getXiang(RIBaoXiang xiang) {
        if (view!=null){
            view.getXiang(xiang);
        }
    }

    @Override
    public void getDate(DateBean dateBean) {
        if (view!=null){
            view.getDate(dateBean);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
