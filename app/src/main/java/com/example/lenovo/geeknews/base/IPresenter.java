package com.example.lenovo.geeknews.base;

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void deatchView();

}
