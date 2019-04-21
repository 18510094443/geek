package com.example.lenovo.geeknews.view.zhihu;

import com.example.lenovo.geeknews.base.IView;
import com.example.lenovo.geeknews.model.bean.zhihu.DateBean;
import com.example.lenovo.geeknews.model.bean.zhihu.HotBean;
import com.example.lenovo.geeknews.model.bean.zhihu.RIBaoXiang;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;

public interface RIBaoView extends IView {

    void getRiBao(RiBaoBean riBao);

    void getZhuanlan(ZhuanLanBean zhuanLanBean);

    void getHot(HotBean hotBean);

    void getXiang(RIBaoXiang xiang);

    void getDate(DateBean dateBean);
}
