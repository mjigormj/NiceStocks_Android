package br.com.nicestocks.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Stock {

    private String name;
    private Double marcketValue = 0.0;
    private Double avgCust = 0.0;
    private Double totalPrice = 0.0;
    private Double moneyEarned = 0.0;
    private int stockQtd = 0;
    private Document doc;
    private Double avgPrice;

    public void stock(String name) throws Exception {
        this.setName(name);
        this.setDoc(Jsoup.connect("https://www.google.com/finance/quote/" + this.getName() + ":BVMF").get());
        this.setMarcketValue();
    }

        /*public String dayRange() {
            return getDoc().getElementsByClass("P6K39c").get(1).text();
        }

        public String percentVariance() {
            return getDoc().getElementsByClass("JwB6zf").get(17).text();
        }*/

    // Metodos especiais
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    /*public Double getAvgPrice() {
        return avgPrice;
    }
    public void setAvgPrice(Double marcketValue, int stockQtd) {
        this.avgPrice = marcketValue/stockQtd;
    }*/
    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) throws IOException {
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

    public Double getMarcketValue() {
        return marcketValue;
    }

    public void setMarcketValue() {
        this.marcketValue = Double.parseDouble(this.getDoc().getElementsByClass("YMlKec fxKbKc").text().replace("R$", ""));
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double marcketValue, int stockQtd) {
        this.totalPrice = marcketValue * stockQtd;
    }

    public Double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(Double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    //Builder

    public static class StockBuilder {
        private String name;
        private Double marcketValue = 0.0;
        private Double avgCust = 0.0;
        private Double totalPrice = 0.0;
        private Double moneyEarned = 0.0;
        private int stockQtd = 0;
        private Document doc;
        private Double avgPrice;

        public StockBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StockBuilder setMarcketValue(Double marcketValue) {
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

        public StockBuilder setMoneyEarned(Double moneyEarned) {
            this.moneyEarned = moneyEarned;
            return this;
        }

        public StockBuilder setStockQtd(int stockQtd) {
            this.stockQtd = stockQtd;
            return this;
        }

        public StockBuilder setDoc(Document doc) {
            this.doc = doc;
            return this;
        }

        public StockBuilder setAvgPrice(Double avgPrice) {
            this.avgPrice = avgPrice;
            return this;
        }

        public static StockBuilder builder() {
            return new StockBuilder();
        }

        public Stock build() {
            Stock stock = new Stock();
            stock.name = name;
            stock.marcketValue = marcketValue;
            stock.avgCust = avgCust;
            stock.totalPrice = totalPrice;
            stock.moneyEarned = moneyEarned;
            stock.stockQtd = stockQtd;
            stock.doc = doc;
            stock.avgPrice = avgPrice;
            return stock;
        }
    }
}
