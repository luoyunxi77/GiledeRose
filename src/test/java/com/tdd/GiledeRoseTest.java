package com.tdd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GiledeRoseTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

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

    @Test
    public void given_one_store_and_some_general_goods_of_in_sell_and_quality_is_0_and_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_is_unchanging() {
        Goods good1 = new Goods(3, 0);
        Goods good2 = new Goods(5, 0);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].getSellIn(), is(2));
        assertThat(giledeRose.getGoods()[0].getQuality(), is(0));

        assertThat(giledeRose.getGoods()[1].getSellIn(), is(4));
        assertThat(giledeRose.getGoods()[1].getQuality(), is(0));
    }

    @Test
    public void given_one_store_and_some_general_goods_of_in_sell_and_quality_is_less_than_0_and_when_updateOneDay_then_throw_exception_with_message() {
        Goods good1 = new Goods(3, -3);
        Goods good2 = new Goods(5, -5);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("quality can not be less than 0");
        giledeRose.updateOneDay();
    }

    @Test
    public void given_one_store_and_some_general_goods_of_in_sell_and_quality_is_greater_than_50_and_when_updateOneDay_then_throw_exception_with_message() {
        Goods good1 = new Goods(3, 100);
        Goods good2 = new Goods(5, 51);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("quality can not be greater than 50");
        giledeRose.updateOneDay();
    }
}
