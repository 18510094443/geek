package com.example.lenovo.geeknews.ui.weixin.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;
import com.example.lenovo.geeknews.model.bean.weixin.SearchBean;
import com.example.lenovo.geeknews.presenter.weixin.WeCharPresenter;
import com.example.lenovo.geeknews.ui.weixin.activity.WeiXinActivity;
import com.example.lenovo.geeknews.ui.weixin.adapter.WeChatAdapter;
import com.example.lenovo.geeknews.view.weixin.WeChatView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatChFragment extends BaseFragment implements WeChatView {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private String key = "52b7ec3471ac3bec6846577e79f20e4c";
    private int num = 10;
    private int page = 1;
    private List<FragmentBean.NewslistBean> list;
    private WeChatAdapter weChatAdapter;
    private List<FragmentBean.NewslistBean> contentlist;
    private String search;

    @Override
    protected void initData() {
        ((WeCharPresenter) presenter).getChat(key, num, page);

    }

    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();

        weChatAdapter = new WeChatAdapter(list, getContext());

        rv.setAdapter(weChatAdapter);
    }

    @Override
    protected BasePresenter createpresenter() {
        return new WeCharPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_weat_ch;
    }

    @Override
    public void getWeChat(FragmentBean fragmentBean) {
        contentlist = fragmentBean.getNewslist();
        WeChatAdapter weChatAdapter = new WeChatAdapter(contentlist, getContext());
        rv.setAdapter(weChatAdapter);
        this.weChatAdapter.OnClick(new WeChatAdapter.OnItemClick() {
            @Override
            public void OnItem(int pos) {
                Intent intent = new Intent(getContext(), WeiXinActivity.class);
                intent.putExtra("title", list.get(pos).getTitle());
                intent.putExtra("url", list.get(pos).getUrl());
                intent.putExtra("image", list.get(pos).getPicUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getWord(FragmentBean fragmentBean) {
       /* newslist = fragmentBean.getNewslist();
        weChatAdapter1 = new WeChatAdapter(newslist, getContext());
        rv.setAdapter(weChatAdapter1);*/
        List<FragmentBean.NewslistBean> newslist = fragmentBean.getNewslist();
        contentlist.addAll(newslist);
        weChatAdapter.notifyDataSetChanged();

//        weChatAdapter.addData(fragmentBean);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void data(SearchBean bean) {
        search = bean.getSearch();
//        contentlist.clear();
        ((WeCharPresenter) presenter).getWord(key, num, page, search);
        /*list.addAll(newslist);
        weChatAdapter1.notifyDataSetChanged();*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
