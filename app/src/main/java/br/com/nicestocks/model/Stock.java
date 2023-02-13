package br.com.nicestocks.model;

import org.jsoup.nodes.Document;

import java.io.IOException;

public class Stock {
    private String name;
    private String marcketValue = "";
    private Double avgCust = 0.0;
    private Double totalPrice = 0.0;
    private int stockQtd = 0;
    private Document doc = null;

    private Stock stock() throws Exception {
        return this;
    }


    // Metodos especiais
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) throws Exception {
        this.doc = doc;
    }

    public Double getAvgCust() {
        return avgCust;
    }

    public void setAvgCust(Double avgCust, int stockQtd) {
        this.avgCust = avgCust / stockQtd;
    }


    public int getStockQtd() {
        return stockQtd;
    }

    public void setStockQtd(int stockQtd) {
        this.stockQtd = stockQtd;
    }

    public String getMarcketValue() {
        return marcketValue;
    }

    public void setMarcketValue(String setMarcketValue) {
        this.marcketValue = setMarcketValue;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double marcketValue, int stockQtd) {
        this.totalPrice = marcketValue * stockQtd;
    }

    //Builder

    public static class StockBuilder {
        private String name;
        private String marcketValue;
        private Double avgCust = 0.0;
        private Double totalPrice = 0.0;
        private int stockQtd = 0;
        private Document doc;

        public StockBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StockBuilder setMarcketValue(String marcketValue) {
            this.marcketValue = marcketValue;
            return this;
        }

        public StockBuilder setAvgCust(Double avgCust) {
            this.avgCust = avgCust;
            return this;
        }

        public StockBuilder setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public StockBuilder setStockQtd(int stockQtd) {
            this.stockQtd = stockQtd;
            return this;
        }

        public StockBuilder setDoc() throws IOException {
            this.doc = doc;
            return this;
        }

        public static StockBuilder builder() {
            return new StockBuilder();
        }

        public Stock build() {
            Stock stock = new Stock();
            stock.name = name;
            stock.avgCust = avgCust;
            stock.totalPrice = totalPrice;
            stock.stockQtd = stockQtd;
            stock.marcketValue = marcketValue;
            stock.doc = doc;
            return stock;
        }

    }
}
