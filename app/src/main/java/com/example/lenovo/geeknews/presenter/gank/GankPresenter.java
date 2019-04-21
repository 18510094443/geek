package com.example.lenovo.geeknews.presenter.gank;

import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.model.http.gank.GankModel;
import com.example.lenovo.geeknews.view.gank.GankView;

public class GankPresenter<V extends GankView> extends BasePresenter<V> implements GankModel.GankFInish {

    private GankModel gankModel = new GankModel();

    public void getData(String tech,int num,int page){
        if (gankModel!=null){
            gankModel.getTechList(this,tech,num,page);
        }
    }

    public void getData(int num,int page){
        gankModel.getGirlList(this,num,page);
    }

    public void getData(int num){
        gankModel.getRandomGirl(this,num);
    }

    @Override
    public void getTechList(GankItemBean gankItemBean) {
        if (view!=null){
            view.getTechList(gankItemBean);
        }
    }

    @Override
    public void getGirlList(GankItemBean gankItemBean) {
        if (view!=null){
            view.getGirlList(gankItemBean);
        }
    }

    @Override
    public void getRandomGirl(GankItemBean gankItemBean) {
        if (view!=null){
            view.getRandomGirl(gankItemBean);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
