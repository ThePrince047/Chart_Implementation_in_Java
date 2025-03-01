package com.example.chartimplementjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class BarChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        FrameLayout chartContainer = view.findViewById(R.id.chartContainer);

        // Create BarChart dynamically
        BarChart barChart = new BarChart(getContext());
        chartContainer.addView(barChart); // Add chart to layout

        // Set up data
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, 50));
        entries.add(new BarEntry(2, 80));
        entries.add(new BarEntry(3, 60));

        BarDataSet dataSet = new BarDataSet(entries, "Bar Chart Data");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(dataSet);

        barChart.setData(barData);
        barChart.invalidate(); // Refresh chart

        return view;
    }
}
