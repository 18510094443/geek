package com.example.lenovo.geeknews.ui.gank.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.presenter.gank.GankPresenter;
import com.example.lenovo.geeknews.ui.gank.activity.GankActivity;
import com.example.lenovo.geeknews.ui.gank.adapter.GankAdapter;
import com.example.lenovo.geeknews.view.gank.GankView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends BaseFragment implements GankView {


    @BindView(R.id.iv_tech_blur)
    ImageView ivTechBlur;
    @BindView(R.id.iv_tech_origin)
    ImageView ivTechOrigin;
    @BindView(R.id.tv_tech_copyright)
    TextView tvTechCopyright;
    @BindView(R.id.tech_appbar)
    AppBarLayout techAppbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    private List<GankItemBean.ResultsBean> list;
    private GankAdapter gankAdapter;
    private String type = "前端";
//    private ImageView img;

    @Override
    protected void initData() {
        ((GankPresenter) presenter).getData(type, 20, 1);
        ((GankPresenter) presenter).getData(20);
    }

    @Override
    protected void initView(View view) {
//        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_image, null);
//        img = inflate.findViewById(R.id.img);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        gankAdapter = new GankAdapter(list, getContext(), type);
        rv.setAdapter(gankAdapter);
    }

    @Override
    protected BasePresenter createpresenter() {
        return new GankPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_android;
    }

    @Override
    public void getTechList(GankItemBean gankItemBean) {
        List<GankItemBean.ResultsBean> results = gankItemBean.getResults();
        list.addAll(results);
        gankAdapter.notifyDataSetChanged();

        gankAdapter.OnClick(new GankAdapter.OnItemClick() {
            @Override
            public void OnItem(int pos) {
                Intent intent = new Intent(getContext(), GankActivity.class);
                intent.putExtra("url",list.get(pos).getUrl());
                intent.putExtra("title",list.get(pos).getDesc());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getGirlList(GankItemBean gankItemBean) {

    }

    @Override
    public void getRandomGirl(GankItemBean gankItemBean) {
        Glide.with(getContext()).load(gankItemBean.getResults().get(0).getUrl()).into(ivTechBlur);
        tvTechCopyright.setText(gankItemBean.getResults().get(0).getWho());
    }

}
