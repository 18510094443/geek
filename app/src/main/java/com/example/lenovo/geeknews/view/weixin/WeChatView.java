package com.example.lenovo.geeknews.view.weixin;

import com.example.lenovo.geeknews.base.IView;
import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;

public interface WeChatView extends IView {

    void getWeChat(FragmentBean fragmentBean);
    void getWord(FragmentBean fragmentBean);

}
