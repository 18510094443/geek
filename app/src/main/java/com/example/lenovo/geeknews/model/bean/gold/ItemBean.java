package com.example.lenovo.geeknews.model.bean.gold;

import java.io.Serializable;

public class ItemBean implements Serializable   {

    public String name;
    public boolean isSelected;

    public ItemBean(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
