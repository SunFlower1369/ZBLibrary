package com.example.yingweng.lalagame.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yingweng.lalagame.R;

public class NewsFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView latestNewsText;
    private TextView latestHotText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        initVie();
        initEvent();
        return view;
    }

    public void initVie(){
        latestNewsText = view.findViewById(R.id.latestNewsText);
        latestHotText = view.findViewById(R.id.latestHotText);
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
