package com.example.yingweng.lalagame.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.adapter.NewsAdapter;
import com.example.yingweng.lalagame.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {
    public NewsListFragment() {
    }
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<News> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private View view;
    private NewsAdapter newsAdapter;
    private LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, container, false);
        initData();
        initView();
        initEvent();
        return view;
    }

    private void initData() {
        News news = new News();
        news.setImageUrl("http://img0.imgtn.bdimg.com/it/u=4038201010,2185369392&fm=26&gp=0.jpg");
        news.setNewsTitle("地狱之刃塞纳的献祭");
        news.setNewsDescrpotion("《地狱之刃：塞娜的献祭（Hellblade：Senua's Sacrifice）》是一款心理恐怖与动作冒险的交互式电影类型游戏，制作方Ninja");
        newsList.add(news);

        News news2 = new News();
        news2.setImageUrl("http://img3.imgtn.bdimg.com/it/u=1983821123,341448610&fm=26&gp=0.jpg");
        news2.setNewsTitle("地狱之刃塞纳的献祭");
        news2.setNewsDescrpotion("《地狱之刃：塞娜的献祭（Hellblade：Senua's Sacrifice）》是一款心理恐怖与动作冒险的交互式电影类型游戏，制作方Ninja");
        newsList.add(news2);

        News news3 = new News();
        news3.setImageUrl("http://img2.imgtn.bdimg.com/it/u=460934234,1583368746&fm=26&gp=0.jpg");
        news3.setNewsTitle("战地1");
        news3.setNewsDescrpotion("啦啦啦这里是战地1");
        newsList.add(news3);
    }

    private void initView() {
        swipeRefreshLayout = view.findViewById(R.id.layout_swipe_refresh);
        recyclerView = view.findViewById(R.id.recyclerView);
        Context context = getContext();
        linearLayoutManager = new LinearLayoutManager(context);
        //解决事件有父级消费，true为自己消费。
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        // 传入context，使用Glide获取图片。
        newsAdapter = new NewsAdapter(newsList, context);
        recyclerView.setAdapter(newsAdapter);
        //监听SwipeRefreshLayout.OnRefreshListener
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateData();
                //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
                newsAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void initEvent(){
        recyclerView.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
                //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
                newsAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    // 下拉刷新
    @SuppressLint("WrongConstant")
    private void updateData() {
        Toast.makeText(getActivity(), "加载完成", 500).show();
        // 将数据添加到第一个
        newsAdapter.notifyDataSetChanged();
    }

    //每次上拉加载的时候，就加载十条数据到RecyclerView中
    private void loadMoreData() {
        for (int i = 0; i < 5; i++) {
            News news = new News();
            news.setImageUrl("http://img0.imgtn.bdimg.com/it/u=4038201010,2185369392&fm=26&gp=0.jpg");
            news.setNewsTitle("地狱之刃塞纳的献祭");
            news.setNewsDescrpotion("《地狱之刃：塞娜的献祭（Hellblade：Senua's Sacrifice）》是一款心理恐怖与动作冒险的交互式电影类型游戏，制作方Ninja");
            newsList.add(news);
            newsAdapter.notifyDataSetChanged();
        }
    }

}
