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
            it.updateOneDay();
        }
    }
}
