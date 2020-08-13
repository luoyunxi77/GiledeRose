package com.tdd;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GiledeRoseTest {

    @Test
    public void given_one_store_and_some_general_goods_of_in_sell_and_quality_between_0_and_50_when_updateOneDay_then_sellIn_and_quality_decrease_by_1() {
        Goods good1 = new Goods(3, 25);
        Goods good2 = new Goods(5, 50);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].getSellIn(), is(2));
        assertThat(giledeRose.getGoods()[0].getQuality(), is(24));

        assertThat(giledeRose.getGoods()[1].getSellIn(), is(4));
        assertThat(giledeRose.getGoods()[1].getQuality(), is(49));
    }
}
