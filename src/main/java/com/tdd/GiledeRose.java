package com.tdd;

public class GiledeRose {
    private Goods[] goods;

    public GiledeRose(Goods[] goods) {
        this.goods = goods;
    }

    public Goods[] getGoods() {
        return goods;
    }

    public void updateOneDay() {
        for (Goods it : goods) {
            if (it.getQuality() == 0) {
                it.setQuality(0);
            } else {
                it.setQuality(it.getQuality() - 1);
            }
            it.setSellIn(it.getSellIn() - 1);
        }
    }
}
