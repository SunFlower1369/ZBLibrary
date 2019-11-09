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

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

public class NewsStatisticsColumn extends Fragment {
    private View view;
    private ColumnChartView columnChartView;
    private ColumnChartData columnChartData;
    private final static String[] kinds = new String[]{"射击游戏", "角色扮演", "竞速,", "解密", "格斗游戏", "棋牌"};
    private final static int[] kindValues = new int[]{0, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_statistics_clonum, container, false);
        initView();
        initData();
        return view;
    }

    private void initView() {
        columnChartView = view.findViewById(R.id.columnChartView);
    }

    private void initData() {
        int numColumns = kinds.length;
        List<AxisValue> axisXValues = new ArrayList<AxisValue>();
        List<AxisValue> axisYValues = new ArrayList<AxisValue>();
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> subcolumnValues;

        for (int j = 0; j < kindValues.length; j++) {
            axisYValues.add(new AxisValue(j).setValue(kindValues[j]));
        }
        for (int i = 0; i < numColumns; i++) {
            subcolumnValues = new ArrayList<SubcolumnValue>();
            switch (i) {
                case 0:
                    subcolumnValues.add(new SubcolumnValue((float) 9000, ChartUtils.COLOR_GREEN));
                    break;
                case 1:
                    subcolumnValues.add(new SubcolumnValue((float) 4000, ChartUtils.COLOR_ORANGE));
                    break;
                case 2:
                    subcolumnValues.add(new SubcolumnValue((float) 3000, ChartUtils.COLOR_RED));
                    break;
                case 3:
                    subcolumnValues.add(new SubcolumnValue((float) 6666, ChartUtils.COLOR_BLUE));
                    break;
                case 4:
                    subcolumnValues.add(new SubcolumnValue((float) 1500, ChartUtils.COLOR_VIOLET));
                    break;
                case 5:
                    subcolumnValues.add(new SubcolumnValue((float) 7000, ChartUtils.DEFAULT_COLOR));
                    break;
                default:
                    break;
            }
            axisXValues.add(new AxisValue(i).setLabel(kinds[i]));
            columns.add(new Column(subcolumnValues).setHasLabelsOnlyForSelected(true));
        }
        columnChartData = new ColumnChartData(columns);
        columnChartData.setAxisXBottom(new Axis(axisXValues).setHasLines(true));
        columnChartData.setAxisYLeft(new Axis(axisYValues).setHasLines(true).setMaxLabelChars(6));
        columnChartView.setColumnChartData(columnChartData);
        columnChartView.setValueSelectionEnabled(true);
        columnChartView.setZoomType(ZoomType.HORIZONTAL);
    }

}
