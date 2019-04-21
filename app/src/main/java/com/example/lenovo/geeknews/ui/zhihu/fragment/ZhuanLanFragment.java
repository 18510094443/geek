package com.example.lenovo.geeknews.ui.zhihu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;
import com.example.lenovo.geeknews.presenter.zhihu.ZhiHuPresenter;
import com.example.lenovo.geeknews.ui.zhihu.adapter.ZhuanLanAdapter;
import com.example.lenovo.geeknews.view.zhihu.RIBaoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanLanFragment extends BaseFragment implements RIBaoView {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private List<ZhuanLanBean.DataBean> list;
    private ZhuanLanAdapter zhuanLanAdapter;

    @Override
    protected void initData() {
        ((ZhiHuPresenter) presenter).getData();
    }

    @Override
    protected void initView(View view) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(gridLayoutManager);

        list = new ArrayList<>();
        zhuanLanAdapter = new ZhuanLanAdapter(list, getContext());
        rv.setAdapter(zhuanLanAdapter);

    }

    @Override
    protected BasePresenter createpresenter() {
        return new ZhiHuPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_zhuan_lan;
    }

    @Override
    public void getRiBao(RiBaoBean riBao) {

    }

    @Override
    public void getZhuanlan(ZhuanLanBean zhuanLanBean) {
        List<ZhuanLanBean.DataBean> data = zhuanLanBean.getData();

        list.addAll(data);

        zhuanLanAdapter.notifyDataSetChanged();
    }

    @Override
    public void getHot(HotBean hotBean) {

    }

    @Override
    public void getXiang(RIBaoXiang xiang) {

    }

    @Override
    public void getDate(DateBean dateBean) {

    }
}
