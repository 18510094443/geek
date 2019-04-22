package com.example.lenovo.geeknews.ui.v2ex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.model.bean.v2ex.VtexNaviGationBean;
import com.example.lenovo.geeknews.widget.FlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter {

    List<VtexNaviGationBean> list;
    Context context;

    public MyAdapter(List<VtexNaviGationBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.vtex, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
//        holder.tvTitle.setText(list.get(i).getT());
        holder.flNodeContent.removeAllViews();
        TextView tvNode = new TextView(context);
        tvNode.setText(list.get(i).getTitle());
        holder.flNodeContent.addView(tvNode);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<VtexNaviGationBean> list1) {
        list.addAll(list1);
        notifyDataSetChanged();
    }



    class ViewHolder extends V2exAdapter.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.fl_node_content)
        FlowLayout flNodeContent;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
