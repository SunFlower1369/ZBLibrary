package com.example.yingweng.lalagame.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.adapter.MyFragmentPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView latestNewsText;
    private TextView latestHotText;
    private ViewPager mviewPager;
    // 添加碎片
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news,container,false);
        initView();
        initEvent();
        return view;
    }

    public void initView(){
        latestNewsText = view.findViewById(R.id.latestNewsText);
        latestHotText = view.findViewById(R.id.latestHotText);
        // 通过fragmentManager，替换布局文件中的FrameLayout
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.replace_frameLayout,new NewsListFragment());
        fragmentTransaction.commit();


        // 添加碎片
//        mFragments = new ArrayList<>();
//        // 添加游戏新闻列表
//        mFragments.add(new NewsListFragment());
        // 设置适配器
//        mAdapter = new MyFragmentPageAdapter(getChildFragmentManager(), mFragments);
//        mviewPager.setAdapter(mAdapter);
    }

    public void  initEvent(){
        latestNewsText.setOnClickListener(this);
        latestHotText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == latestNewsText.getId()){
            Log.d("YESLALA", "点击阿双方均奥斯卡荆防颗粒阿双方各卡洛: ");
        }else{
            Log.d("YESLALA", "点击阿双方均奥斯卡荆防颗粒阿双方各卡洛: ");
        }
    }
}
