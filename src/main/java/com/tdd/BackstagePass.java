package com.tdd;

public class BackstagePass extends Goods {
    public BackstagePass(int sellIn, int quality) {
        super(sellIn, quality);
    }

    @Override
    public void updateQuality() {
        isQualityValid();

        if (sellIn > 10) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
