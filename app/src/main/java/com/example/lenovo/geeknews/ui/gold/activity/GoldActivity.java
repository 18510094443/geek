package com.example.lenovo.geeknews.ui.gold.activity;


import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.app.Constants;
import com.example.lenovo.geeknews.base.BaseActivity;
import com.example.lenovo.geeknews.model.bean.gold.ItemBean;
import com.example.lenovo.geeknews.presenter.gold.GoldPresenter;
import com.example.lenovo.geeknews.ui.gold.adapter.GoldAdapter;
import com.example.lenovo.geeknews.view.gold.GoldView;
import com.example.lenovo.geeknews.widget.recycler.SimpleItemTouchHelper;

import java.util.ArrayList;

import butterknife.BindView;

public class GoldActivity extends BaseActivity implements GoldView {

    @BindView(R.id.rv)
    RecyclerView mRlv;
    private ArrayList<ItemBean> mList;

    @Override
    protected void initView() {
        mList = (ArrayList<ItemBean>) getIntent().getSerializableExtra(Constants.DATA);

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        GoldAdapter rlvGoldShowAdapter = new GoldAdapter(mList);
        mRlv.setAdapter(rlvGoldShowAdapter);

        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        SimpleItemTouchHelper helper = new SimpleItemTouchHelper(rlvGoldShowAdapter);
        helper.setSwipeEnable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(helper);
        //关联recyclerView
        itemTouchHelper.attachToRecyclerView(mRlv);
    }

    @Override
    protected GoldPresenter createpresenter() {
        return new GoldPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_gold;
    }

    @Override
    public void showLoging(boolean bool) {

    }

    @Override
    public void showNight(boolean night) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA,mList);
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }

}
