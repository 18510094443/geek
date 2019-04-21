package com.example.lenovo.geeknews.ui.gank.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.presenter.gank.GankPresenter;
import com.example.lenovo.geeknews.ui.gank.activity.GirlActivity;
import com.example.lenovo.geeknews.ui.gank.adapter.GirlAdapter;
import com.example.lenovo.geeknews.view.gank.GankView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GirlFragment extends BaseFragment implements GankView {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private List<GankItemBean.ResultsBean> list;
    private GirlAdapter girlAdapter;

    @Override
    protected void initData() {
        ((GankPresenter)presenter).getData(20,1);
    }

    @Override
    protected void initView(View view) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        list = new ArrayList<>();
        girlAdapter = new GirlAdapter(list, getContext());
        rv.setAdapter(girlAdapter);

        girlAdapter.OnClick(new GirlAdapter.OnItemClick() {
            @Override
            public void OnItem(int pos) {
                Intent intent = new Intent(getContext(), GirlActivity.class);
                intent.putExtra("img",list.get(pos).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    protected BasePresenter createpresenter() {
        return new GankPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_girl;
    }

    @Override
    public void getTechList(GankItemBean gankItemBean) {

    }

    @Override
    public void getGirlList(GankItemBean gankItemBean) {
        List<GankItemBean.ResultsBean> results = gankItemBean.getResults();
        list.addAll(results);
        girlAdapter.notifyDataSetChanged();
    }

    @Override
    public void getRandomGirl(GankItemBean gankItemBean) {

    }

}
