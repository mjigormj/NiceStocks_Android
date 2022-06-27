package br.com.nicestocks.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import br.com.nicestocks.R;
import br.com.nicestocks.controller.StockCardAdapter;
import br.com.nicestocks.model.Stock;
import br.com.nicestocks.model.Stocks;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rv;
    private StockCardAdapter stockAdapter;
    private ArrayList<Stock> stockList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rv = findViewById(R.id.recyclerViewStockCard);
        Content content = new Content();
        content.execute();
        stockAdapter = new StockCardAdapter(stockList, this);
        rv.setAdapter(stockAdapter);


    }


    private class Content extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                for (Stock stock : Stocks.fakeStocks()) {
                    Document doc = Jsoup.connect("https://www.google.com/finance/quote/" + stock.getName() + ":BVMF").get();
                    String valorAtual = doc.getElementsByClass("YMlKec fxKbKc").text().replace("R$", "");
                    stock.setMarcketValue(valorAtual);
                    stockList.add(stock);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            rv.setAdapter(stockAdapter);
            stockAdapter.notifyDataSetChanged();
        }


    }
}