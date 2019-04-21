package com.example.lenovo.geeknews.ui.gold.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by asus on 2019/3/20.
 * 看不到Fragment生命周期不一样
 * FragmentPagerAdapter: onDestroyView(),碎片还在
 * FragmentStatePagerAdapter:onDetach()
 */

public class VpGoldAdpater extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;

    public VpGoldAdpater(FragmentManager fm,
                         ArrayList<Fragment> fragments, ArrayList<String> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
