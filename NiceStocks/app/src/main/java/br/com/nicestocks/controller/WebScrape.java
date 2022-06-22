package br.com.nicestocks.controller;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.nicestocks.model.Stock;

public class WebScrape {

    private class webScrape extends AsyncTask<Void, Void, List<Stock>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Stock> doInBackground(Void... voids) {
            List<Stock> stock = new ArrayList<>();

            try {
                Document document = Jsoup.connect("https://www.google.com/finance/quote/" + "name"+ ":BVMF").get();

            }catch (IOException e) {
                e.printStackTrace();
            }

            return stock;

        }

        @Override
        protected void onPostExecute(List<Stock> stock) {
            super.onPostExecute(stock);
        }
    }
}
