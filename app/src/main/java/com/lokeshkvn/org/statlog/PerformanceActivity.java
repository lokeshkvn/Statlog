package com.lokeshkvn.org.statlog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by DELL PC on 10-05-2017.
 */

public class PerformanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.performance);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.performance_actionbar);
        ImageView backButton = (ImageView) findViewById(R.id.back_2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(0, 85),
                new DataPoint(1, 70),
                new DataPoint(2, 80),
                new DataPoint(3, 90),
        });
        graph.addSeries(series);

        // styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });

        series.setSpacing(35);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"you", "Average", "Highest", "Maximum"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"0", "50", "100"});

        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        GraphView graph1 = (GraphView) findViewById(R.id.graph1);
        BarGraphSeries<DataPoint> series1 = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(0, 45),
                new DataPoint(1, 75),
                new DataPoint(2, 87),
                new DataPoint(3, 89),
        });
        graph1.addSeries(series1);

        // styling
        series1.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 3, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });

        series1.setSpacing(35);

        StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(graph1);
        staticLabelsFormatter1.setHorizontalLabels(new String[]{"you", "Average", "Highest", "Maximum"});
        staticLabelsFormatter1.setVerticalLabels(new String[]{"0", "50", "100"});

        graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);
    }
}