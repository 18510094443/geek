package com.example.lenovo.geeknews.ui.gold.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.app.Constants;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gold.ItemBean;
import com.example.lenovo.geeknews.presenter.gold.GoldPresenter;
import com.example.lenovo.geeknews.ui.gold.activity.GoldActivity;
import com.example.lenovo.geeknews.ui.gold.adapter.GoldAdapter;
import com.example.lenovo.geeknews.ui.gold.adapter.VpGoldAdpater;
import com.example.lenovo.geeknews.view.gold.GoldView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldFragment extends BaseFragment implements GoldView {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private String[] mTypes = new String[]{"iOS", "工具资源", "阅读", "产品", "Android",
            "前段", "设计", "后端"};
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;
    private ArrayList<ItemBean> mList;
    private int REQUEST_CODE = 100;
    private ArrayList<ItemBean> mSelectList;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();
        for (int i = 0; i < mTypes.length; i++) {
            ItemBean itemBean = new ItemBean(mTypes[i], true);
            mList.add(itemBean);
        }
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        initFragments(mList);
        setVp();
    }

    @Override
    protected BasePresenter createpresenter() {
        return new GoldPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_gold;
    }
    

    @OnClick(R.id.iv_arrow)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), GoldActivity.class);
        if (mSelectList == null){
            mSelectList = mList;
        }
        intent.putExtra(Constants.DATA,mSelectList);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode ==REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK && data != null){
                mSelectList = (ArrayList<ItemBean>) data.getSerializableExtra(SyncStateContract.Constants.DATA);
                initFragments(mSelectList);
                setVp();
            }
        }
    }

    private void setVp() {
        VpGoldAdpater vpGoldAdpater = new VpGoldAdpater(getChildFragmentManager(),mFragments,mTitles);
        vp.setAdapter(vpGoldAdpater);
        tabLayout.setupWithViewPager(vp);
    }

    private void initFragments(ArrayList<ItemBean> list) {
        mFragments.clear();
        mTitles.clear();
        for (int i = 0; i < list.size(); i++) {
            ItemBean itemBean = list.get(i);
            if (itemBean.isSelected){
                mFragments.add(GoldDatsFragment.newInstance(itemBean.name));
                mTitles.add(itemBean.name);
            }
        }
    }
}
