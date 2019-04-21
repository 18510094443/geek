package com.example.lenovo.geeknews.presenter.weixin;

import com.example.lenovo.geeknews.base.BasePresenter;
import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;
import com.example.lenovo.geeknews.model.http.weixin.WeChatModel;
import com.example.lenovo.geeknews.view.weixin.WeChatView;

import java.util.HashMap;
import java.util.Map;

public class WeCharPresenter<V extends WeChatView>extends BasePresenter<V> implements WeChatModel.WeChatFinish {

    private WeChatModel weChatModel = new WeChatModel();

    public void getChat(String key,int num,int page){
        if (weChatModel!=null){
            weChatModel.getWeChat(this,key,num,page);
        }
    }

    public void getWord(String key,int num,int page,String word){
        if (weChatModel!=null){
            weChatModel.getWoed(this,key,num,page,word);
        }
    }

    @Override
    public void getWeChat(FragmentBean fragmentBean) {
        if (view!=null){
            view.getWeChat(fragmentBean);
        }
    }

    @Override
    public void getWord(FragmentBean fragmentBean) {
        if (view!=null){
            view.getWord(fragmentBean);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
