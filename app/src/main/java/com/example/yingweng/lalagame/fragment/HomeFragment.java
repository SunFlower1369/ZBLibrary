package com.example.yingweng.lalagame.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.activity.NewsDetailsActivity;
import com.example.yingweng.lalagame.loader.GlideImageLoader;
import com.example.yingweng.lalagame.model.News;
import com.example.yingweng.lalagame.util.SwithcFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {
    View view;
    private List<URL> images;
    private List<String> titles;
    private List<News> newsList;
    // 使用轮播图库 https://github.com/youth5201314/banner
    private Banner banner;
    private FrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        initView();
        initEvent();
        return view;
    }

    public void initView() {
        frameLayout = view.findViewById(R.id.frameLayout_home);
        banner = (Banner) view.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Stack);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public void initData() {
        images = new ArrayList<>();
        newsList = new ArrayList<>();
        titles = new ArrayList<>();
        newsList.add(new News("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573293217535&di=9e9765e18240720885e645a268f31618&imgtype=0&src=http%3A%2F%2Fpic2.52pk.com%2Ffiles%2F180118%2F7229806_100431_6908.jpg", "守卫先锋2要出来的", "守卫先锋2出来的按时发哈是否会家属房卡是开发has卡萨发挥空间按时和开发商花式咖啡滑块爱是"));
        newsList.add(new News("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573890941&di=3ecd4c2ba6166c28585fe5b74d098ab8&imgtype=jpg&er=1&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2Fca5060fb715e2fb2ea418165d5dfc6c7224d89f6.png", "守卫先锋2要出来的", "守卫先锋2出来的按时发哈是否会家属房卡是开发has卡萨发挥空间按时和开发商花式咖啡滑块爱是"));
        newsList.add(new News("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1013156276,1365609281&fm=26&gp=0.jpg", "守卫先锋2要出来的", "守卫先锋2出来的按时发哈是否会家属房卡是开发has卡萨发挥空间按时和开发商花式咖啡滑块爱是"));
        newsList.add(new News("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573295587486&di=32793b6e5c896669b507924d89df2ce7&imgtype=0&src=http%3A%2F%2Fpic.paopaoche.net%2Fup%2F2015-1%2F201501300919586133055.jpg", "杀戮空间电锯", "守卫先锋2出来的按时发哈是否会家属房卡是开发has卡萨发挥空间按时和开发商花式咖啡滑块爱是"));
        newsList.add(new News("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1013156276,1365609281&fm=26&gp=0.jpg", "守卫先锋2要出来的", "守卫先锋2出来的按时发哈是否会家属房卡是开发has卡萨发挥空间按时和开发商花式咖啡滑块爱是"));
        for (int i = 0; i < newsList.size(); i++) {
            try {
                images.add(new URL(newsList.get(i).getImageUrl()));
                titles.add(newsList.get(i).getNewsTitle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void initEvent() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                toNewsDetail(newsList.get(position));
            }
        });
        FragmentManager fragmentManager = getChildFragmentManager();
        NewsListFragment fragment = new NewsListFragment();
        SwithcFragment swithcFragment = new SwithcFragment(R.id.frameLayout_home, fragment, fragmentManager);
        swithcFragment.commit();
    }

    // 跳转到详情页面
    public void toNewsDetail(News news) {
        Intent intent = new Intent(getContext(), NewsDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("serializableNews", news);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
