package com.example.lenovo.geeknews.ui.zhihu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.lenovo.geeknews.ui.zhihu.activity.TimeActivity;
import com.example.lenovo.geeknews.ui.zhihu.activity.ZhuhuActivity;
import com.example.lenovo.geeknews.ui.zhihu.adapter.RiBaoAdapter;
import com.example.lenovo.geeknews.view.zhihu.RIBaoView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiBaoFragment extends BaseFragment implements RIBaoView {


    private static final String TAG = RiBaoFragment.class.getName();
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.time)
    FloatingActionButton time;
    Unbinder unbinder;

    private List<RiBaoBean.StoriesBean> storiesBeans;
    private List<RiBaoBean.TopStoriesBean> topStoriesBeans;
    private RiBaoAdapter riBaoAdapter;

    @Override
    protected void initData() {
        ((ZhiHuPresenter) presenter).getData();
    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        storiesBeans = new ArrayList<>();
        topStoriesBeans = new ArrayList<>();
        riBaoAdapter = new RiBaoAdapter(storiesBeans, topStoriesBeans, getContext());
        rv.setAdapter(riBaoAdapter);
    }

    @Override
    protected BasePresenter createpresenter() {
        return new ZhiHuPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_ri_bao;
    }

    @Override
    public void getRiBao(RiBaoBean riBao) {
//        riBaoAdapter.setData(riBao);
        String date = riBao.getDate();
        final List<RiBaoBean.StoriesBean> stories = riBao.getStories();
        List<RiBaoBean.TopStoriesBean> top_stories = riBao.getTop_stories();

        storiesBeans.addAll(stories);
        topStoriesBeans.addAll(top_stories);
        riBaoAdapter.notifyDataSetChanged();

        riBaoAdapter.OnClick(new RiBaoAdapter.OnItemClick() {
            @Override
            public void OnItem(int pos) {
                Intent intent = new Intent(getContext(), ZhuhuActivity.class);
                intent.putExtra("id", stories.get(pos).getId());
                intent.putExtra("title", stories.get(pos).getTitle());
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ondata(String date) {
        Log.d(TAG, "ondata: " + date);
        date = "news/before/" + date;
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6);
        riBaoAdapter.date = year + "-" + month + "-" + day;
        storiesBeans.clear();
        ((ZhiHuPresenter) presenter).getData1(date);
    }

    @Override
    public void getZhuanlan(ZhuanLanBean zhuanLanBean) {

    }

    @Override
    public void getHot(HotBean hotBean) {

    }

    @Override
    public void getXiang(RIBaoXiang xiang) {

    }

    @Override
    public void getDate(DateBean dateBean) {
        List<DateBean.StoriesBean> storiesn = dateBean.getStories();
        ArrayList<RiBaoBean.StoriesBean> list = new ArrayList<>();
        for (int i = 0; i < storiesn.size(); i++) {
            DateBean.StoriesBean storiesBean = storiesn.get(i);
            RiBaoBean.StoriesBean bean = new RiBaoBean.StoriesBean();
            bean.setImages(storiesBean.getImages());
            bean.setTitle(storiesBean.getTitle());
            list.add(bean);
        }
        storiesBeans.addAll(list);
        riBaoAdapter.setStoriesBeans(list);
        riBaoAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.time)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), TimeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
