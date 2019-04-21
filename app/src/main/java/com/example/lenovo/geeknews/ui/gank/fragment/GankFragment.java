package com.example.lenovo.geeknews.ui.gank.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;
import com.example.lenovo.geeknews.view.gank.GankView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment implements GankView {


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
        fragments.add(new AndroidFragment());
        fragments.add(new IosFragment());
        fragments.add(new WebFragment());
        fragments.add(new GirlFragment());

        final List<String> title = new ArrayList<>();
        title.add("Android");
        title.add("Ios");
        title.add("前端");
        title.add("福利");

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
                return fragments.size();
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
        return R.layout.fragment_gank;
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
}
