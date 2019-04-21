package com.example.lenovo.geeknews.widget.recycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.lenovo.geeknews.ui.gold.adapter.GoldAdapter;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by asus on 2019/3/20.
 */

public class SimpleItemTouchHelper extends ItemTouchHelper.Callback {

    private ItemCallBack mCallBack;
    private boolean mSwipeEnable = true;


    public void setSwipeEnable(boolean enable){
        mSwipeEnable = enable;
    }

    public SimpleItemTouchHelper(ItemCallBack callBack) {

        mCallBack = callBack;
    }

    /**
     * 返回可以滑动的方向,一般使用makeMovementFlags(int,int)或makeFlag(int, int)
     * 来构造我们的返回值
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //允许上下拖拽
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许向左滑动
        int swipe = ItemTouchHelper.LEFT;
        return makeMovementFlags(drag,swipe);
    }

    /**
     *上下拖动item时回调,可以调用Adapter的notifyItemMoved方法来交换两个ViewHolder的位置，
     * 最后返回true，表示被拖动的ViewHolder已经移动到了目的位置
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView,
                          RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        mCallBack.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    /**
     *   当用户左右滑动item时达到删除条件就会调用,一般为一半,条目继续滑动删除,否则弹回
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mCallBack.onItemDelete(viewHolder.getAdapterPosition());
    }

    /**
     * 支持长按拖动,默认true
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    /**
     * 支持滑动删除,即可以调用到onSwiped()方法,默认是true
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return mSwipeEnable;
    }
}
