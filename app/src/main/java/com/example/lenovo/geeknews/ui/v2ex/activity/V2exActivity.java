package com.example.lenovo.geeknews.ui.v2ex.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseActivity;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.v2ex.VtexNaviGationBean;
import com.example.lenovo.geeknews.ui.v2ex.adapter.MyAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import qdx.stickyheaderdecoration.NormalDecoration;

public class V2exActivity extends BaseActivity {

    private static final String TAG = "V2exActivity.this";
    @BindView(R.id.my_recycle)
    RecyclerView myRecycle;
    public String url = "https://www.v2ex.com/";
    private List<VtexNaviGationBean> list1;
    private List<VtexNaviGationBean> list;
    private MyAdapter myAdapter;


    //李旭阳
    @Override
    protected void initView() {
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(list,this);
        myRecycle.setAdapter(myAdapter);

        NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return list.get(i).getTab();
            }
        };
        /*decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(int i) {
                View inflate = LayoutInflater.from(V2exActivity.this).inflate(R.layout.v2ex_heard,null);
                TextView tv = inflate.findViewById(R.id.tv);
                tv.setText(list.get(i).getTab());
                return inflate;
            }
        });*/
        myRecycle.addItemDecoration(decoration);
        initData();
    }

    private void initData() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    final List<VtexNaviGationBean> list = new ArrayList<>();
                    Document document = Jsoup.connect(url).get();
                    Elements elements = document.select("div.box div.cell");
                    for (Element element : elements) {
                        Elements select = element.select("table tbody tr td span.fade");
                        String text = select.text();
                        Log.d(TAG, "标题: " + text);
                        Elements select2 = element.select("table tbody tr td > a");
                        String text2 = select2.text();
                        Log.d(TAG, "文本: " + text2);
                        VtexNaviGationBean bean = new VtexNaviGationBean();
                        bean.setTab(text);
                        bean.setTitle(text2);
                        list.add(bean);
                    }
                    list1 = list.subList(list.size() - 9, list.size());
                    Log.d(TAG,"文本"+ list1.toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            /*list.addAll(list1);
                            myAdapter.notifyDataSetChanged();*/
                            myAdapter.addData(list1);
                        }
                    });
                } catch (Exception e) {
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
        return R.layout.activity_v2ex;
    }
}
