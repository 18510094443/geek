package com.example.lenovo.geeknews.base;

import com.example.lenovo.geeknews.model.http.HttpFinishCallBack;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseObServer<T> implements Observer<T> {

    private HttpFinishCallBack httpFinishCallBack;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseObServer(HttpFinishCallBack httpFinishCallBack) {
        this.httpFinishCallBack = httpFinishCallBack;
    }

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
        if (httpFinishCallBack!=null){
            httpFinishCallBack.hideProgress();
        }
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onComplete() {
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
        if (httpFinishCallBack!=null){
            httpFinishCallBack.hideProgress();
        }
    }
}
