package com.tdd;

public class BackstagePass extends Goods {
    public BackstagePass(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void updateQuality() {
        isQualityValid();
        increaseQuality();

        if (sellIn < 11 && sellIn > 5) {
            increaseQuality();
        }
    }
}
