package br.com.nicestocks.model;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Stocks {
    public static List<Stock> fakeStocks() throws IOException {
        return Arrays.asList(
                Stock.StockBuilder.builder()
                        .setName("CPTS11")
                        .setAvgPrice(97.0)
                        .setStockQtd(12)
                        .setDoc(Jsoup.connect("https://www.google.com/finance/quote/" + "CPTS11" + ":BVMF").get())
                        .setMarcketValue(97.1)
                        .setAvgCust(97.1)
                        .setMoneyEarned(97.1)
                        .build(),

                Stock.StockBuilder.builder()
                        .setName("PETR4")
                        .setAvgPrice(97.0)
                        .setStockQtd(12)
                        .setDoc(Jsoup.connect("https://www.google.com/finance/quote/" + "CPTS11" + ":BVMF").get())
                        .setMarcketValue(97.1)
                        .setAvgCust(97.1)
                        .setMoneyEarned(97.1)
                        .build()
        );
    }
}
