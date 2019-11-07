package com.example.yingweng.lalagame.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.model.News;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> list;
    private Context context;

    // 自定义内部类
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitleView;
        TextView textDescribeView;

        // itemView是每一个子项目的外层包裹的布局，通过它可以拿到子项目的实例。
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.newsItemIamge);
            textTitleView = itemView.findViewById(R.id.newsItemTitle);
            textDescribeView = itemView.findViewById(R.id.newsItemdescribe);
        }
    }

    public NewsAdapter(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 当子项滚动到屏幕中间的时候，通过position获得news实例
        News news = list.get(position);

//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher_round) //预加载图片
//                .error(R.drawable.ic_launcher_foreground) //加载失败图片
//                .diskCacheStrategy(DiskCacheStrategy.NONE) //缓存
//                .RequestOptions.bitmapTransform(RoundedCorners(20)); //圆角


        // 使用Glide处理图片请求和圆角   https://www.jianshu.com/p/791ee473a89b
        Glide.with(context).load(news.getImageUrl())
                .apply(bitmapTransform(new RoundedCornersTransformation(20, 0, RoundedCornersTransformation.CornerType.ALL)))
                .into(holder.imageView);
        holder.textTitleView.setText(news.getNewsTitle());
        holder.textDescribeView.setText(news.getNewsDescrpotion());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
