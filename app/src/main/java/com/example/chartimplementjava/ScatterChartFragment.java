package com.example.chartimplementjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ScatterChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        FrameLayout chartContainer = view.findViewById(R.id.chartContainer);

        // Create ScatterChart dynamically
        ScatterChart scatterChart = new ScatterChart(getContext());
        chartContainer.addView(scatterChart);

        // Set up data
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 30));
        entries.add(new Entry(2, 70));
        entries.add(new Entry(3, 50));
        entries.add(new Entry(4, 90));

        ScatterDataSet dataSet = new ScatterDataSet(entries, "Scatter Chart Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12f);

        List<IScatterDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        ScatterData scatterData = new ScatterData(dataSets);
        scatterChart.setData(scatterData);
        scatterChart.invalidate(); // Refresh chart

        return view;
    }
}
