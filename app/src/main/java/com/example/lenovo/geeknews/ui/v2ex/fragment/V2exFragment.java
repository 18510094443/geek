package com.example.lenovo.geeknews.ui.v2ex.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class V2exFragment extends BaseFragment {


    public String url = "https://www.v2ex.com/";
    Unbinder unbinder;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder1;
    private ArrayList<String> list;
    private ArrayList<String> herf;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        herf = new ArrayList<>();
        getData();
    }

    @Override
    protected void initView(View view) {

    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(url).get();
                    Elements select = document.select("div#Tabs > a");
                    for (Element se : select) {
                        String text = se.text();
                        String herfurl = se.attr("href");
                        Log.d("tag", "====>" + text);
                        Log.d("tag", "====>" + herfurl);
                        list.add(text);
                        herf.add(herfurl);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (list.size() > 0) {
                                tab.setupWithViewPager(vp);
                                vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                                    @Override
                                    public Fragment getItem(int i) {
                                        return new V2exitemFragment(herf.get(i));
                                    }

                                    @Nullable
                                    @Override
                                    public CharSequence getPageTitle(int position) {
                                        return list.get(position);
                                    }

                                    @Override
                                    public int getCount() {
                                        return list.size();
                                    }
                                });

                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    protected BasePresenter createpresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_v2ex;
    }

}
