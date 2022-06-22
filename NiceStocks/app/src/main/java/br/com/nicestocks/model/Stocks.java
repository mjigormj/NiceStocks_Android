package br.com.nicestocks.model;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Stocks {
    public static List<Stock> fakeStocks() throws IOException {
        return Arrays.asList(
                Stock.StockBuilder.builder()
                        .setName("NUBR33")
                        .setStockQtd(12)
                        //.setDoc("CPTS11")
                        .setMarcketValue(97.1)
                        .setAvgCust(97.1)
                        .build(),

                Stock.StockBuilder.builder()
                        .setName("PETR4")
                        .setStockQtd(12)
                        //.setDoc("CPTS11")
                        .setMarcketValue(97.1)
                        .setAvgCust(97.1)
                        .build(),

                Stock.StockBuilder.builder()
                        .setName("CPTS11")
                        .setStockQtd(12)
                        //.setDoc("CPTS11")
                        .setMarcketValue(97.1)
                        .setAvgCust(97.1)
                        .build(),

                Stock.StockBuilder.builder()
                        .setName("CMIN3")
                        .setStockQtd(12)
                        //.setDoc("CPTS11")
                        .setMarcketValue(97.1)
                        .setAvgCust(97.1)
                        .build()
        );
    }
}
