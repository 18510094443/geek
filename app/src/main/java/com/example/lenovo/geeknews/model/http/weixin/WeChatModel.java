package com.example.lenovo.geeknews.model.http.weixin;

import com.example.lenovo.geeknews.base.BaseObServer;
import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;
import com.example.lenovo.geeknews.model.http.HttpFinishCallBack;
import com.example.lenovo.geeknews.model.http.HttpManger;
import com.example.lenovo.geeknews.utils.RxUtils;

import java.util.Map;

public class WeChatModel {

    public interface WeChatFinish extends HttpFinishCallBack{
        void getWeChat(FragmentBean fragmentBean);
        void getWord(FragmentBean fragmentBean);
    }

    public void getWeChat(final WeChatFinish weChatFinish,String key, int num, int page){
        weChatFinish.showProgress();
        HttpManger.getWeiXinApis().getWeChat(key, num, page).compose(RxUtils.<FragmentBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(weChatFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        weChatFinish.getWeChat((FragmentBean) o);
                    }
                });
    }

    public void getWoed(final WeChatFinish weChatFinish, String key, int num, int page, String word){
        weChatFinish.showProgress();
        HttpManger.getWeiXinApis().getWord(key, num, page, word).compose(RxUtils.<FragmentBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObServer<Object>(weChatFinish) {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        weChatFinish.getWord((FragmentBean) o);
                    }
                });
    }


}
