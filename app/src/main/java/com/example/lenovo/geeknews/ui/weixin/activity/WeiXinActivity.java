package com.example.lenovo.geeknews.ui.weixin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseActivity;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;
import com.example.lenovo.geeknews.presenter.weixin.WeCharPresenter;
import com.example.lenovo.geeknews.presenter.zhihu.ZhiHuPresenter;
import com.example.lenovo.geeknews.view.weixin.WeChatView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeiXinActivity extends BaseActivity implements WeChatView {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wb)
    WebView wb;
    private String url;
    private String title;
    private String image;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        image = intent.getStringExtra("image");
        toolbar.setTitle(title);
        //setSupportActionBar(toolbar);
        wb.loadUrl(url);
    }

    @Override
    protected BasePresenter createpresenter() {
        return new WeCharPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_wei_xin;
    }

    @Override
    public void getWeChat(FragmentBean fragmentBean) {

    }

    @Override
    public void getWord(FragmentBean fragmentBean) {

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
