package com.example.yingweng.lalagame.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.model.News;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class NewsDetailsActivity extends AppCompatActivity {
    private News news;
    private TextView topTitle;
    private ImageView imageView;
    private TextView newsDescrpotion;
    private TextView back;
    private  ImageView love;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        initData();
        initView();
        initEvent();
    }

    public void initView() {
        topTitle = findViewById(R.id.tv_back_title);
        imageView = findViewById(R.id.detail_image_view);
        newsDescrpotion = findViewById(R.id.detail_text_view);
        love = findViewById(R.id.love_image_view);
        back = findViewById(R.id.tv_back_icon);
        topTitle.setText(news.getNewsTitle());
        topTitle.setVisibility(View.VISIBLE);
        // 图片处理
        Glide.with(NewsDetailsActivity.this).load(news.getImageUrl())
                .apply(bitmapTransform(new RoundedCornersTransformation(20, 0, RoundedCornersTransformation.CornerType.ALL)))
                .into(imageView);
        newsDescrpotion.setText(news.getNewsDescrpotion());
    }

    public void initData() {
        // 获取跳转数据
        Bundle bundle = getIntent().getExtras();
        news = (News) bundle.get("serializableNews");
    }

    public void initEvent() {
        // 点击返回
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsActivity.this.finish();
            }
        });
        // 点击收藏
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


}
