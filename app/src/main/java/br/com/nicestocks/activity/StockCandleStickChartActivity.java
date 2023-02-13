package br.com.nicestocks.activity;
import br.com.nicestocks.R;
import br.com.nicestocks.model.MinMaxValue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.CandlestickFormatter;
import com.androidplot.xy.CandlestickSeries;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockCandleStickChartActivity extends AppCompatActivity {

    private XYPlot candleStickChart;
    private XYSeries stockValues;
    private CandlestickSeries candlestickSeries;
    private CandlestickFormatter candlestickFormatter;

    ArrayList<MinMaxValue> minMaxValues = (ArrayList<MinMaxValue>) Arrays.asList(
        new MinMaxValue(1, 124.5f, 126.5f, 125.5f, 125.5f),
        new MinMaxValue(2, 125.5f, 128.5f, 126.5f, 126.5f),
        new MinMaxValue(3, 126.5f, 129.5f, 128.5f, 128.5f),
        new MinMaxValue(4, 127.5f, 130.5f, 129.5f, 129.5f),
        new MinMaxValue(5, 128.5f, 131.5f, 130.5f, 130.5f));

    Number[] series1Numbers = {1, 124.5f, 126.5f, 125.5f, 125.5f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candlestick_chart);

        // Find the XYPlot view in the layout
        candleStickChart = findViewById(R.id.activity_candlestick_chart);

        // Create a series to store the y-axis values

        stockValues = new SimpleXYSeries((List<? extends Number>) (
                minMaxValues.get(0)
        ), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Stock Values");

        // Create a candlestick series
        candlestickSeries = new CandlestickSeries((List<CandlestickSeries.Item>) stockValues);
        candleStickChart.addSeries((XYSeries) candlestickSeries, new CandlestickFormatter(this, R.xml.candlestick_formatter));

        // Set the properties for the chart
        candleStickChart.setRangeBoundaries(0, 150, BoundaryMode.FIXED);
        candleStickChart.setDomainBoundaries(0, 6, BoundaryMode.FIXED);
        candleStickChart.setDomainStepValue(1);
        candleStickChart.setLinesPerRangeLabel(3);
        candleStickChart.setRangeLabel("Stock Price");
        candleStickChart.setDomainLabel("Day");
        candleStickChart.getGraph().getLineLabelStyle(XYGraphWidget.Edge.LEFT).setFormat(new DecimalFormat("#"));
    }
}