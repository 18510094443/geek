package com.example.lenovo.geeknews.ui.gold.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.model.bean.gold.ItemBean;
import com.example.lenovo.geeknews.widget.recycler.ItemCallBack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoldAdapter extends RecyclerView.Adapter implements ItemCallBack {
    private static final String TAG = "RlvGoldShowAdapter";
    private ArrayList<ItemBean> mList;

    public GoldAdapter(ArrayList<ItemBean> list) {
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gold, null);
        return new ShowVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ShowVH showVH = (ShowVH) holder;
        final ItemBean itemBean = mList.get(position);
        showVH.mTvName.setText(itemBean.name);
        showVH.mSW.setChecked(itemBean.isSelected);
        showVH.mSW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                itemBean.isSelected = isChecked;
            }
        });

        showVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Logger.logD(TAG,mList.toString());
                //ToastUtil.showShort("索引:"+position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        Collections.swap(mList,fromPosition,toPosition);
        //局部刷新
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        //删除数据
        mList.remove(position);
        //局部刷新
        notifyItemRemoved(position);
    }

    class ShowVH extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.sw)
        SwitchCompat mSW;

        public ShowVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
