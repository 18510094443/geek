package com.example.lenovo.geeknews.ui.gank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseActivity;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.presenter.gank.GankPresenter;
import com.example.lenovo.geeknews.view.gank.GankView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GankActivity extends BaseActivity implements GankView {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wb)
    WebView wb;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        ((GankPresenter) presenter).getData("Android", 1, 20);
        ((GankPresenter) presenter).getData("iOS", 1, 20);
        ((GankPresenter) presenter).getData("前端", 1, 20);
        wb.loadUrl(url);
    }

    @Override
    protected BasePresenter createpresenter() {
        return new GankPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_gank;
    }

    @Override
    public void getTechList(GankItemBean gankItemBean) {

    }

    @Override
    public void getGirlList(GankItemBean gankItemBean) {

    }

    @Override
    public void getRandomGirl(GankItemBean gankItemBean) {

    }

    @Override
    public void showLoging(boolean bool) {

    }

    @Override
    public void showNight(boolean night) {

    }

    @Override
    public void showError(String error) {

    }
}
