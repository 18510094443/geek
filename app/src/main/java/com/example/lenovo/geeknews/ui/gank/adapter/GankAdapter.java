package com.example.lenovo.geeknews.ui.gank.adapter;

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
import com.example.lenovo.geeknews.model.bean.gank.GankItemBean;

import java.util.List;

public class GankAdapter extends RecyclerView.Adapter {
    private List<GankItemBean.ResultsBean> list;
    private Context context;
    private String type;
    private OnItemClick li;

    public GankAdapter(List<GankItemBean.ResultsBean> list, Context context,String type) {
        this.list = list;
        this.context = context;
        this.type=type;
    }

   /* @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else{
            return 1;
        }
    }*/

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       /* if (i==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_image, null);
            MyViewHolder1 myViewHolder1 = new MyViewHolder1(inflate);
            return myViewHolder1;
        }else{*/
            View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
            MyViewHolder myViewHolder = new MyViewHolder(inflate);
            return myViewHolder;
//        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

       /* if (viewHolder instanceof MyViewHolder1){
           if (list.size()>0&&list!=null){
               MyViewHolder1 holder1 = (MyViewHolder1) viewHolder;
               Glide.with(context).load(list.get(i).getUrl()).into(holder1.img);
           }
        }else{*/
            MyViewHolder holder = (MyViewHolder) viewHolder;

            ImageView imageView = holder.itemView.findViewById(R.id.iv_tech_icon);

            if (type.equals("Android")){
                imageView.setImageResource(R.mipmap.ic_android);
            }else if (type.equals("iOS")){
                imageView.setImageResource(R.mipmap.ic_ios);
            }else{
                imageView.setImageResource(R.mipmap.ic_web);
            }
            holder.tv.setText(list.get(i).getDesc());
            holder.tv1.setText(list.get(i).getWho());
            holder.tv2.setText(list.get(i).getPublishedAt());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    li.OnItem(i);
                }
            });
//        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        TextView tv1;
        TextView tv2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.iv_tech_icon);
            tv=itemView.findViewById(R.id.tv_tech_title);
            tv1=itemView.findViewById(R.id.tv_tech_author);
            tv2=itemView.findViewById(R.id.tv_tech_time);
        }
    }

  /*  class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView img;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
        }
    }*/

  public void OnClick(OnItemClick li){
      this.li=li;
  }

   public interface OnItemClick{
       void OnItem(int pos);
   }


}
