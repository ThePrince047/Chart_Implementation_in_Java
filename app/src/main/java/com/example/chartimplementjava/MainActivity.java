package com.example.chartimplementjava;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.ScatterChart;

public class MainActivity extends AppCompatActivity {

    private Button btnBarChart, btnLineChart, btnPieChart, btnScatterChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window=getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.blue));

        btnBarChart = findViewById(R.id.btnBarChart);
        btnLineChart = findViewById(R.id.btnLineChart);
        btnPieChart = findViewById(R.id.btnPieChart);
        btnScatterChart = findViewById(R.id.btnScatterChart);

        // Default chart when activity starts
        replaceFragment(new BarChartFragment());

        btnBarChart.setOnClickListener(v -> replaceFragment(new BarChartFragment()));
        btnLineChart.setOnClickListener(v -> replaceFragment(new LineChartFragment()));
        btnPieChart.setOnClickListener(v -> replaceFragment(new PieChartFragment()));
        btnScatterChart.setOnClickListener(v -> replaceFragment(new ScatterChartFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.chartContainer, fragment);
        fragmentTransaction.commit();
    }
}
