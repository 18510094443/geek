package com.example.lenovo.geeknews.ui.zhihu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.model.bean.zhihu.ZhuanLanBean;

import java.util.List;

public class ZhuanLanAdapter extends RecyclerView.Adapter {

    List<ZhuanLanBean.DataBean> list;
    Context context;

    public ZhuanLanAdapter(List<ZhuanLanBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhuanlan_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        //加载一张圆角图片
        RoundedCorners roundedCorners = new RoundedCorners(10);
        RequestOptions options1 = RequestOptions.bitmapTransform(roundedCorners).override(140,100);
        Glide.with(context).load(list.get(i).getThumbnail()).apply(options1).into(holder.img);
        holder.tv.setText(list.get(i).getDescription());
        holder.tv1.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        TextView tv1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
