package com.example.lenovo.geeknews.ui.weixin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.model.bean.weixin.FragmentBean;

import java.util.List;

public class WeChatAdapter extends RecyclerView.Adapter {
    private List<FragmentBean.NewslistBean> list;
    private Context context;
    private OnItemClick li;

    public WeChatAdapter(List<FragmentBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wechat, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        Glide.with(context).load(list.get(i).getPicUrl()).into(holder.img);
        holder.tv.setText(list.get(i).getTitle());
        holder.tv1.setText(list.get(i).getDescription());
        holder.tv2.setText(list.get(i).getCtime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                li.OnItem(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(FragmentBean fragmentBean) {
        List<FragmentBean.NewslistBean> newslist = fragmentBean.getNewslist();
        list.addAll(newslist);
        notifyDataSetChanged();

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        TextView tv1;
        TextView tv2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.iv_wechat_item_image);
            tv=itemView.findViewById(R.id.tv_wechat_item_title);
            tv1=itemView.findViewById(R.id.tv_wechat_item_from);
            tv2=itemView.findViewById(R.id.tv_wechat_item_time);
        }
    }

    public interface OnItemClick{
        void OnItem(int pos);
    }

    public void OnClick(OnItemClick li){
        this.li=li;
    }
}
