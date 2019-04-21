package com.example.lenovo.geeknews.ui.gank.activity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseActivity;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.view.gank.GankView;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GirlActivity extends BaseActivity implements GankView {

    @BindView(R.id.img)
    PhotoView img;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("img");

        Glide.with(this).asBitmap().load(image).into(img);

    }

    @Override
    protected BasePresenter createpresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_girl;
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
