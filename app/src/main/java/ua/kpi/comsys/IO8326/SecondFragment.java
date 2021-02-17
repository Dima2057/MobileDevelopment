package ua.kpi.comsys.IO8326;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SecondFragment extends Fragment {
    PieChart pieChart;
    private LineGraphSeries<DataPoint> series;

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        double x = 0.01;
        double y = 5;
        final int[] MY_COLORS = {Color.rgb(192, 0, 0),
                                 Color.rgb(255, 255, 0),
                                 Color.rgb(0, 254, 0)};

        GraphView graphView = getActivity().findViewById(R.id.graph);
        Switch switcher = getActivity().findViewById(R.id.switcher);
        switcher.setChecked(false);
        series = new LineGraphSeries<>();
        switcher.setOnCheckedChangeListener((CompoundButton buttonView, boolean check) -> {
            if (check == true) {
                graphView.setVisibility(View.INVISIBLE);
                pieChart.setVisibility(View.VISIBLE);
            } else {
                pieChart.setVisibility(View.INVISIBLE);
                graphView.setVisibility(View.VISIBLE);
            }
        });

        for (double i = x; i <= y; i += 0.1) {
            series.appendData(new DataPoint(i, Math.pow(i, 2)), true, 100);
        }

        graphView.addSeries(series);
        pieChart = Objects.requireNonNull(getActivity()).findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleRadius(25f);

        List<PieEntry> value = new ArrayList<>();
        value.add(new PieEntry(35f, "Green"));
        value.add(new PieEntry(40f, "Yellow"));
        value.add(new PieEntry(25f, "Red"));

        PieDataSet pieDataSet = new PieDataSet(value, "Colours");
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        ArrayList<Integer> colors = new ArrayList<>();
        for (int c : MY_COLORS) colors.add(c);
        pieDataSet.setColors(MY_COLORS[2], MY_COLORS[1], MY_COLORS[0]);
        pieChart.animateXY(1400, 1400);
    }
}
