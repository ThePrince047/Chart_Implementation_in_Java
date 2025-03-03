package com.example.chartimplementjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        FrameLayout chartContainer = view.findViewById(R.id.chartContainer);

        // Create PieChart dynamically
        PieChart pieChart = new PieChart(getContext());
        chartContainer.addView(pieChart);

        // Set up data
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(30, "A"));
        entries.add(new PieEntry(20, "B"));
        entries.add(new PieEntry(50, "C"));

        PieDataSet dataSet = new PieDataSet(entries, "Pie Chart Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12f);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.setUsePercentValues(true);
        pieChart.animateXY(1000, 1000);
        pieChart.invalidate(); // Refresh chart

        return view;
    }
}
