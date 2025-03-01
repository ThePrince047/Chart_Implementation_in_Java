package com.example.chartimplementjava;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    LineChart lineChart;
    PieChart pieChart;
    RadarChart radarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Charts
        barChart = findViewById(R.id.barChart);
        lineChart = findViewById(R.id.lineChart);
        pieChart = findViewById(R.id.pieChart);
        radarChart = findViewById(R.id.radarChart);

        setupBarChart();
        setupLineChart();
        setupPieChart();
        setupRadarChart();
    }

    private void setupBarChart() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 100));
        barEntries.add(new BarEntry(2, 200));
        barEntries.add(new BarEntry(3, 150));
        barEntries.add(new BarEntry(4, 180));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Bar Data");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);
        barChart.invalidate();
    }

    private void setupLineChart() {
        ArrayList<Entry> lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(1, 30));
        lineEntries.add(new Entry(2, 80));
        lineEntries.add(new Entry(3, 150));
        lineEntries.add(new Entry(4, 200));

        LineDataSet lineDataSet = new LineDataSet(lineEntries, "Line Data");
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setCircleColor(Color.RED);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setValueTextSize(14f);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.getDescription().setEnabled(false);
        lineChart.invalidate();
    }

    private void setupPieChart() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(30, "A"));
        pieEntries.add(new PieEntry(20, "B"));
        pieEntries.add(new PieEntry(50, "C"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Pie Data");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.invalidate();
    }

    private void setupRadarChart() {
        ArrayList<RadarEntry> radarEntries = new ArrayList<>();
        radarEntries.add(new RadarEntry(4));
        radarEntries.add(new RadarEntry(2));
        radarEntries.add(new RadarEntry(5));
        radarEntries.add(new RadarEntry(3));

        RadarDataSet radarDataSet = new RadarDataSet(radarEntries, "Radar Data");
        radarDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        RadarData radarData = new RadarData(radarDataSet);
        radarChart.setData(radarData);
        radarChart.getDescription().setEnabled(false);
        radarChart.invalidate();
    }
}
