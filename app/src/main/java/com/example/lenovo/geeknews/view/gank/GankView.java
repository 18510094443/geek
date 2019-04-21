package com.example.lenovo.geeknews.view.gank;

import com.example.lenovo.geeknews.base.IView;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;

public interface GankView extends IView {

    void getTechList(GankItemBean gankItemBean);
    void getGirlList(GankItemBean gankItemBean);
    void getRandomGirl(GankItemBean gankItemBean);

}
