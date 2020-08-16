package com.tdd;

public class Goods {

    public int sellIn;

    public int quality;

    public Goods(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateOneDay() {
        updateQuality();
        updateSellIn();

        if (isExpired()) {
            updateQualityWhenExpired();
        }
    }

    private void updateSellIn() {
        sellIn = sellIn - 1;
    }

    public void updateQuality() {
        isQualityValid();
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    public void updateQualityWhenExpired() {
        updateQuality();
    }

    public void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    public void isQualityValid() {
        if (quality < 0) {
            throw new IllegalArgumentException("quality can not be less than 0");
        }
        if (quality > 50) {
            throw new IllegalArgumentException("quality can not be greater than 50");
        }
    }
}
