package br.com.nicestocks.model;

public class MinMaxValue {
    private int x;
    private float open;
    private float high;
    private float low;
    private float close;

    public MinMaxValue(int x, float open, float high, float low, float close) {
        this.x = x;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public int getX() {
        return x;
    }

    public float getOpen() {
        return open;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public float getClose() {
        return close;
    }
}
