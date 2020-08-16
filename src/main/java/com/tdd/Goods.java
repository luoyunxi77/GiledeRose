package com.tdd;

public class Goods {

    private int sellIn;

    private int quality;

    public Goods(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void passOneDay() {
        updateSellIn();
        updateQuality();
    }

    private void updateSellIn() {
        sellIn = sellIn - 1;
    }

    private void updateQuality() {
        if (quality == 0) {
            quality = 0;
        } else if (quality < 0) {
            throw new IllegalArgumentException("quality can not be less than 0");
        } else {
            quality = quality - 1;
        }
    }
}
