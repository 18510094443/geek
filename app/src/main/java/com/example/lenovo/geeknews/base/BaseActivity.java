package com.example.lenovo.geeknews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<V extends IView,P extends BasePresenter<V>> extends AppCompatActivity {

    protected Context context;
    protected P presenter;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        context=this;
        onViewCreatedView();
        initView();
    }

    protected abstract void initView();

    private void onViewCreatedView() {
        presenter=createpresenter();
        unbinder=ButterKnife.bind(this);
        if (presenter!=null){
            presenter.attachView((V) this);
        }

    }

    protected abstract P createpresenter();

    protected abstract int getLayout();

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter!=null){
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.deatchView();
        }
        unbinder.unbind();
    }
}
