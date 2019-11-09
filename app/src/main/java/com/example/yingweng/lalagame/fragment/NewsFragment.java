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
import com.example.yingweng.lalagame.util.SwithcFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements View.OnClickListener {
    private SwithcFragment switchFragment;
    private View view;
    private TextView latestNewsText;
    private TextView latestHotText;
    private ViewPager mviewPager;
    private FragmentManager fragmentManager;
    // 储存碎片
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        initEvent();
        return view;
    }
    public void initView() {
        latestNewsText = view.findViewById(R.id.latestNewsText);
        latestHotText = view.findViewById(R.id.latestHotText);
        // 通过fragmentManager，替换布局文件中的FrameLayout
        fragmentManager = getChildFragmentManager();
        // 切换fragment，用于切换最新页面中的最新资讯和最近热门
        switchFragment = new SwithcFragment(R.id.replace_frameLayout,new NewsListFragment(),fragmentManager);
        switchFragment.commit();
    }
    public void initEvent() {
        latestNewsText.setOnClickListener(this);
        latestHotText.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == latestNewsText.getId()) {
            switchFragment = new SwithcFragment(R.id.replace_frameLayout,new NewsListFragment(),fragmentManager);
            switchFragment.commit();
        } else {
            switchFragment = new SwithcFragment(R.id.replace_frameLayout,new  NewsHotFragment(),fragmentManager);
            switchFragment.commit();
        }
    }

    // 用于切换替换fragment
//    public void switchFragment(int layoutId, Fragment fragment) {
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(layoutId, fragment);
//        fragmentTransaction.commit();
//    }
}
