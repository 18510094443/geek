package com.example.lenovo.geeknews.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends IView,T extends BasePresenter<V>> extends Fragment implements IView {
    protected T presenter;
    protected Unbinder unbinder;
    protected Activity activity;
    protected Context context;

    @Override
    public void onAttach(Context context) {
        activity= (Activity) context;
        context=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter=createpresenter();
        if (presenter!=null){
            presenter.attachView((V) this);
        }
        unbinder=ButterKnife.bind(this,view);
        initView(view);
        initData();
    }

    @Override
    public void onDestroy() {
        if (presenter!=null){
            presenter.deatchView();
        }
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoging(boolean bool) {

    }

    @Override
    public void showNight(boolean night) {

    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract T createpresenter();

    protected abstract int getLayout();
}
