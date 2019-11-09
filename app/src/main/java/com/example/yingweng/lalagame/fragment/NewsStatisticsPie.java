package com.example.yingweng.lalagame.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yingweng.lalagame.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

public class NewsStatisticsPie extends Fragment {
    private View view;
    private PieChartView chartView;
    private PieChartData chartData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_statistics_pie, container, false);
        initView();
        initData();
        return view;
    }

    public void initView() {
        chartView = view.findViewById(R.id.chart);
    }

    public void initData() {
        int numValue = 3;
        List<SliceValue> sliceValues = new ArrayList<>();
        for (int i = 0; i < numValue; i++) {
            switch (i + 1) {
                case 1:
                    SliceValue sliceValue1 = new SliceValue(i+1,ChartUtils.COLOR_BLUE);
                    sliceValue1.setTarget(1);
                    sliceValue1.setLabel("射击游戏 30%");
                    sliceValues.add(sliceValue1);
                    break;
                case 2:
                    SliceValue sliceValue2 = new SliceValue(i+1,ChartUtils.COLOR_RED);
                    sliceValue2.setTarget(1);
                    sliceValue2.setLabel("解密 10%");
                    sliceValues.add(sliceValue2);
                    break;
                case 3:
                    SliceValue sliceValue3 = new SliceValue(i+1,ChartUtils.COLOR_GREEN);
                    sliceValue3.setTarget(8);
                    sliceValue3.setLabel("角色扮演 60%");
                    sliceValues.add(sliceValue3);
                    break;
                default:
                    break;
            }
        }

        chartData = new PieChartData(sliceValues);
        chartData.setHasLabels(true);
        chartData.setHasLabelsOnlyForSelected(false);
        chartData.setHasLabelsOutside(false);
        chartView.setPieChartData(chartData);
    }
}
