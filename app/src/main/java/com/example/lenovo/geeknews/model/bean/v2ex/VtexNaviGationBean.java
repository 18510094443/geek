package com.example.lenovo.geeknews.model.bean.v2ex;

public class VtexNaviGationBean {

    String tab;
    String title;

    public VtexNaviGationBean() {
    }

    public VtexNaviGationBean(String tab, String title) {
        this.tab = tab;
        this.title = title;
    }

    @Override
    public String toString() {
        return "VtexNaviGationBean{" +
                "tab='" + tab + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
