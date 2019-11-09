package com.example.yingweng.lalagame.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.yingweng.lalagame.BlankFragment;
import com.example.yingweng.lalagame.R;
import com.example.yingweng.lalagame.adapter.MyFragmentPageAdapter;
import com.example.yingweng.lalagame.fragment.HomeFragment;
import com.example.yingweng.lalagame.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout main_home;
    private LinearLayout main_news;
    private LinearLayout main_vedio;
    private LinearLayout main_me;
    private TextView mainTextHome;
    private TextView mainTextNews;
    private TextView mainTextVedio;
    private TextView mainTextMe;
    private ViewPager viewPager;

    // 添加碎片
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    public void initView() {
        main_home = findViewById(R.id.main_home);
        main_news = findViewById(R.id.main_news);
        main_vedio = findViewById(R.id.main_vedio);
        main_me = findViewById(R.id.main_me);
        mainTextHome = findViewById(R.id.main_text_home);
        mainTextNews = findViewById(R.id.main_text_news);
        mainTextVedio = findViewById(R.id.main_text_vedio);
        mainTextMe = findViewById(R.id.main_text_me);
        viewPager = findViewById(R.id.viewPager);

        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(BlankFragment.newInstance("视频"));
        mFragments.add(BlankFragment.newInstance("我"));
        // init view pager
        mAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(mAdapter);

    }

    public void initEvent() {
        tabOnclick();
        // viewPager滑动改变
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTextNormol();
                switch (position) {
                    case 0:
                        mainTextHome.setTextColor(MainActivity.this.getResources().getColor(R.color.homeBlue));
                        break;
                    case 1:
                        mainTextNews.setTextColor(MainActivity.this.getResources().getColor(R.color.homeYellow));
                        break;
                    case 2:
                        mainTextVedio.setTextColor(MainActivity.this.getResources().getColor(R.color.homePurple));
                        break;
                    case 3:
                        mainTextMe.setTextColor(MainActivity.this.getResources().getColor(R.color.homeBlueness));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setTextNormol() {
        mainTextHome.setTextColor(MainActivity.this.getResources().getColor(R.color.black));
        mainTextNews.setTextColor(MainActivity.this.getResources().getColor(R.color.black));
        mainTextVedio.setTextColor(MainActivity.this.getResources().getColor(R.color.black));
        mainTextMe.setTextColor(MainActivity.this.getResources().getColor(R.color.black));
    }

    public void tabOnclick() {
        main_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextNormol();
                mainTextHome.setTextColor(MainActivity.this.getResources().getColor(R.color.homeBlue));
                viewPager.setCurrentItem(0,false);
            }
        });
        main_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextNormol();
                mainTextNews.setTextColor(MainActivity.this.getResources().getColor(R.color.homeYellow));
                viewPager.setCurrentItem(1,false);

            }
        });
        main_vedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextNormol();
                mainTextVedio.setTextColor(MainActivity.this.getResources().getColor(R.color.homePurple));
                viewPager.setCurrentItem(2,false);

            }
        });
        main_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextNormol();
                mainTextMe.setTextColor(MainActivity.this.getResources().getColor(R.color.homeBlueness));
                viewPager.setCurrentItem(3,false);

            }
        });
    }
}
