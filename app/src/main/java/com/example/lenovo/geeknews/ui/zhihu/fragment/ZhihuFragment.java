package com.example.lenovo.geeknews.ui.zhihu.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFragment extends BaseFragment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RiBaoFragment());
        fragments.add(new ZhuanLanFragment());
        fragments.add(new HotFragment());

        final List<String> title = new ArrayList<>();
        title.add("日报");
        title.add("专栏");
        title.add("热门");

        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }

            @Override
            public int getCount() {
                return title.size();
            }
        });

        tab.setupWithViewPager(vp);
    }

    @Override
    protected BasePresenter createpresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_zhihu;
    }

}
