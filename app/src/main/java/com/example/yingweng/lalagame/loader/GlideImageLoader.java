package com.example.yingweng.lalagame.loader;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        // 显示图片，首页轮播图需要使用使用。
        Glide.with(context).load(path).into(imageView);
    }

}
