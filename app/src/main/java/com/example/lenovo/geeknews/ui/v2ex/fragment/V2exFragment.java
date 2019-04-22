package com.example.lenovo.geeknews.ui.v2ex.fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.ui.v2ex.activity.V2exActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import butterknife.BindView;
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
    @BindView(R.id.img)
    ImageView img;
    private ArrayList<String> list;
    private ArrayList<String> herf;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        herf = new ArrayList<>();
        getData();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), V2exActivity.class);
                startActivity(intent);
            }
        });
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
