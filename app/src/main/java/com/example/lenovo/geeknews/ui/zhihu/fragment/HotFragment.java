package com.example.lenovo.geeknews.ui.zhihu.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.base.BaseFragment;
import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;
import com.example.lenovo.geeknews.presenter.zhihu.ZhiHuPresenter;
import com.example.lenovo.geeknews.ui.zhihu.activity.ZhuhuActivity;
import com.example.lenovo.geeknews.ui.zhihu.adapter.HotAdapter;
import com.example.lenovo.geeknews.view.zhihu.RIBaoView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment implements RIBaoView {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private List<HotBean.RecentBean> list;
    private HotAdapter hotAdapter;

    @Override
    protected void initData() {
        ((ZhiHuPresenter)presenter).getData();
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        list = new ArrayList<>();
        hotAdapter = new HotAdapter(list, getContext());
        rv.setAdapter(hotAdapter);

    }

    @Override
    protected BasePresenter createpresenter() {
        return new ZhiHuPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    public void getRiBao(RiBaoBean riBao) {

    }

    @Override
    public void getZhuanlan(ZhuanLanBean zhuanLanBean) {

    }

    @Override
    public void getHot(HotBean hotBean) {
        List<HotBean.RecentBean> recent = hotBean.getRecent();
        list.addAll(recent);
        hotAdapter.notifyDataSetChanged();
        hotAdapter.OnClick(new HotAdapter.OnItemClick() {
            @Override
            public void OnItem(int pos) {
                Intent intent = new Intent(getContext(), ZhuhuActivity.class);
                intent.putExtra("id",list.get(pos).getNews_id());
                intent.putExtra("title",list.get(pos).getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getXiang(RIBaoXiang xiang) {

    }

    @Override
    public void getDate(DateBean dateBean) {

    }
}
