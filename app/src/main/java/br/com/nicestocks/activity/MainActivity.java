package br.com.nicestocks.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

import br.com.nicestocks.R;
import br.com.nicestocks.controller.StockCardAdapter;
import br.com.nicestocks.model.Stocks;

public class MainActivity extends AppCompatActivity {

    private StockCardAdapter stockCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToHome(View view){
        Intent intent1 = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent1);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_candlestick_chart);
//
//    }
//
//    public void goToHome(View view){
//        Intent intent1 = new Intent(getApplicationContext(), StockCandleStickChartActivity.class);
//        startActivity(intent1);
//    }
}