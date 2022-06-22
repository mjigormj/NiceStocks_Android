package br.com.nicestocks.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

import br.com.nicestocks.R;
import br.com.nicestocks.controller.StockCardAdapter;
import br.com.nicestocks.model.Stocks;

public class HomeActivity extends AppCompatActivity {

    private StockCardAdapter stockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        try {
            stockAdapter = new StockCardAdapter(new ArrayList<>(Stocks.fakeStocks()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        RecyclerView rv = findViewById(R.id.recyclerViewStockCard);
        rv.setAdapter(stockAdapter);
    }
}