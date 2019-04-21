package com.example.lenovo.geeknews.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<T extends IView> implements IPresenter<T>{
    protected T view;
    protected WeakReference<T> weakReference;

    @Override
    public void attachView(T view) {
        weakReference=new WeakReference<T>(view);
        this.view=weakReference.get();
    }

    @Override
    public void deatchView() {
        this.view=null;
    }
}
