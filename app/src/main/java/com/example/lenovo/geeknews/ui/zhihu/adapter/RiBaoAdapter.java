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
import com.example.lenovo.geeknews.R;
import com.example.lenovo.geeknews.model.bean.zhihu.RiBaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RiBaoAdapter extends RecyclerView.Adapter {


    private List<RiBaoBean.StoriesBean> storiesBeans;
    private List<RiBaoBean.TopStoriesBean> topStoriesBeans;
    private Context context;
    public String date;
    private OnItemClick li;

    public void setStoriesBeans(List<RiBaoBean.StoriesBean> storiesBeans) {
        this.storiesBeans = storiesBeans;
    }

    public RiBaoAdapter(List<RiBaoBean.StoriesBean> storiesBeans, List<RiBaoBean.TopStoriesBean> topStoriesBeans, Context context) {
        this.storiesBeans = storiesBeans;
        this.topStoriesBeans = topStoriesBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else{
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.ribaobanner_item, null);
            MyViewHolder1 myViewHolder1 = new MyViewHolder1(inflate);
            return myViewHolder1;
        }else{
            View inflate = LayoutInflater.from(context).inflate(R.layout.ribao_item, null);
            MyViewHolder2 myViewHolder2 = new MyViewHolder2(inflate);
            return myViewHolder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof MyViewHolder1){
            final MyViewHolder1 holder1 = (MyViewHolder1) viewHolder;
            holder1.banner.setImages(topStoriesBeans).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    RiBaoBean.TopStoriesBean storiesBean = (RiBaoBean.TopStoriesBean) path;
                    Glide.with(context).load(storiesBean.getImage()).into(imageView);
                }
            }).start();
            holder1.tv.setText(topStoriesBeans.get(i).getTitle());
        }else{
            MyViewHolder2 holder2 = (MyViewHolder2) viewHolder;
            Glide.with(context).load(storiesBeans.get(i).getImages().get(0)).into(holder2.img);
            holder2.tv.setText(storiesBeans.get(i).getTitle());

            holder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    li.OnItem(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
            return storiesBeans.size();
    }

    public void setData(RiBaoBean riBao) {
        date = riBao.getDate();
        List<RiBaoBean.StoriesBean> stories = riBao.getStories();
        if (stories.size()>0&&stories!=null){
            stories.clear();
            storiesBeans.addAll(stories);
        }

        List<RiBaoBean.TopStoriesBean> top_stories = riBao.getTop_stories();
        if (top_stories.size()>0&&top_stories!=null){
            top_stories.clear();
            topStoriesBeans.addAll(top_stories);
        }
        notifyDataSetChanged();

    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        Banner banner;
        TextView tv;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            banner= itemView.findViewById(R.id.banner);
            tv=itemView.findViewById(R.id.tv);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.ribao_img);
            tv=itemView.findViewById(R.id.ribao_title);
        }
    }

    public void OnClick(OnItemClick li){
        this.li=li;
    }

    public interface OnItemClick{
        void OnItem(int pos);
    }
}
