package com.example.yingweng.lalagame.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.util.SwithcFragment;

public class NewsHotFragment extends Fragment {
    View view;
    private  FrameLayout frameLayout;
    private RelativeLayout switchRelativeLayout;
    private SwithcFragment swithcFragment;
    private FragmentManager fragmentManager;
    private Fragment[] fragmentList = {new NewsStatisticsPie(),new NewsStatisticsColumn()};
    private static Boolean checked_pie = true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_hot,container,false);
        initView();
        initEvent();
        return view;
    }

    private void initView(){
        frameLayout = view.findViewById(R.id.frameLayout);
        fragmentManager = getChildFragmentManager();
        switchRelativeLayout = view.findViewById(R.id.switchRelativeLayout);
        // 初始化显示饼状图
        swithcFragment = new SwithcFragment(R.id.frameLayout,new NewsStatisticsPie(),fragmentManager);
        swithcFragment.commit();
    }

    private  void  initEvent(){
        // 切换事件，点击切换统计图表的展示，柱状图和饼状图。
        switchRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swithcFragment = new SwithcFragment(R.id.frameLayout,checked_pie ? fragmentList[1]:fragmentList[0],fragmentManager);
                swithcFragment.commit();
                checked_pie = !checked_pie;
            }
        });
    }
}
