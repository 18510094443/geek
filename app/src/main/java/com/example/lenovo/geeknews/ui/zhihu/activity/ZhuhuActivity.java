package com.example.lenovo.geeknews.ui.zhihu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseActivity;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;
import com.example.lenovo.geeknews.presenter.zhihu.ZhiHuPresenter;
import com.example.lenovo.geeknews.view.zhihu.RIBaoView;
import butterknife.BindView;

public class ZhuhuActivity extends BaseActivity implements RIBaoView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.ri_img)
    ImageView riImg;
    @BindView(R.id.wb)
    WebView wb;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String title = intent.getStringExtra("title");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        ((ZhiHuPresenter) presenter).getData(id + "");
}

    @Override
    protected BasePresenter createpresenter() {
        return new ZhiHuPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_zhuhu;
    }

    @Override
    public void getRiBao(RiBaoBean riBao) {

    }

    @Override
    public void getZhuanlan(ZhuanLanBean zhuanLanBean) {

    }

    @Override
    public void getHot(HotBean hotBean) {

    }

    @Override
    public void getXiang(RIBaoXiang xiang) {
        Glide.with(this).load(xiang.getImage()).into(riImg);

        String body = xiang.getBody();

        wb.getSettings().setDefaultTextEncodingName("UTF-8");

        wb.loadData(body, "text/html;charset=UTF-8", null);
    }

    @Override
    public void getDate(DateBean dateBean) {

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
