package com.example.lenovo.geeknews.widget.recycler;

/**
 * Created by asus on 2019/3/20.
 */

public interface ItemCallBack {
    //数据交换
    void onItemMove(int fromPosition, int toPosition);

    //数据删除
    void onItemDelete(int position);
}
