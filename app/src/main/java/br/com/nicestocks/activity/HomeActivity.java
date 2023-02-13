package br.com.nicestocks.activity;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;
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
            String passou = "N";
            while (!passou.equals("S")) {
                try {
                    for (Stock stock : Stocks.fakeStocks()) {
                        String stockName = stock.getName();
                        Document doc = Jsoup.connect("https://www.google.com/finance/quote/" + stockName + ":BVMF").get();
                        String valorAtual = doc.getElementsByClass("YMlKec fxKbKc").first().text().replace("R$&nbsp;", "");
                        valorAtual = valorAtual.replace("R$", "");
                        stock.setMarcketValue(valorAtual);
                        stockList.add(stock);
                    }
                    passou = "S";
                } catch (SocketTimeoutException e) {
                    System.out.println("====================ERROR====================");
                    System.out.println("Não foi possível encontrar os dados das ações");
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();

                }
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