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

        assertThat(giledeRose.getGoods()[0].sellIn, is(2));
        assertThat(giledeRose.getGoods()[0].quality, is(24));

        assertThat(giledeRose.getGoods()[1].sellIn, is(4));
        assertThat(giledeRose.getGoods()[1].quality, is(49));
    }

    @Test
    public void given_one_store_and_some_general_goods_of_in_sell_and_quality_is_0_and_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_is_unchanging() {
        Goods good1 = new Goods(3, 0);
        Goods good2 = new Goods(5, 0);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].sellIn, is(2));
        assertThat(giledeRose.getGoods()[0].quality, is(0));

        assertThat(giledeRose.getGoods()[1].sellIn, is(4));
        assertThat(giledeRose.getGoods()[1].quality, is(0));
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

    @Test
    public void given_one_store_and_some_general_goods_of_out_sell_and_quality_between_0_and_50_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_decrease_by_2() {
        Goods good1 = new Goods(-1, 25);
        Goods good2 = new Goods(-5, 50);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].sellIn, is(-2));
        assertThat(giledeRose.getGoods()[0].quality, is(23));

        assertThat(giledeRose.getGoods()[1].sellIn, is(-6));
        assertThat(giledeRose.getGoods()[1].quality, is(48));
    }

    @Test
    public void given_one_store_and_some_BackstagePass_goods_of_sellIn_is_greater_than_10_and_quality_between_0_and_50_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_increase_by_1_but_not_greater_than_50() {
        Goods good1 = new BackstagePass(11, 25);
        Goods good2 = new BackstagePass(20, 50);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].sellIn, is(10));  // updateQuality must before as updateSellIn
        assertThat(giledeRose.getGoods()[0].quality, is(26));

        assertThat(giledeRose.getGoods()[1].sellIn, is(19));
        assertThat(giledeRose.getGoods()[1].quality, is(50));
    }

    @Test
    public void given_one_store_and_some_BackstagePass_goods_of_sellIn_is_between_5_and_10_and_quality_between_0_and_50_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_increase_by_2_but_not_greater_than_50() {
        Goods good1 = new BackstagePass(10, 25);
        Goods good2 = new BackstagePass(6, 50);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].sellIn, is(9));
        assertThat(giledeRose.getGoods()[0].quality, is(27));

        assertThat(giledeRose.getGoods()[1].sellIn, is(5));
        assertThat(giledeRose.getGoods()[1].quality, is(50));
    }

    @Test
    public void given_one_store_and_some_BackstagePass_goods_of_sellIn_is_less_than_6_and_quality_between_0_and_50_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_increase_by_3_but_not_greater_than_50() {
        Goods good1 = new BackstagePass(5, 25);
        Goods good2 = new BackstagePass(1, 50);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].sellIn, is(4));
        assertThat(giledeRose.getGoods()[0].quality, is(28));

        assertThat(giledeRose.getGoods()[1].sellIn, is(0));
        assertThat(giledeRose.getGoods()[1].quality, is(50));
    }

    @Test
    public void given_one_store_and_some_BackstagePass_goods_of_out_sell_and_quality_between_0_and_50_when_updateOneDay_then_sellIn_decrease_by_1_and_quality_is_0() {
        Goods good1 = new BackstagePass(-1, 25);
        Goods good2 = new BackstagePass(-5, 50);
        Goods[] generalGoods = new Goods[]{good1, good2};

        GiledeRose giledeRose = new GiledeRose(generalGoods);
        giledeRose.updateOneDay();

        assertThat(giledeRose.getGoods()[0].sellIn, is(-2));
        assertThat(giledeRose.getGoods()[0].quality, is(0));

        assertThat(giledeRose.getGoods()[1].sellIn, is(-6));
        assertThat(giledeRose.getGoods()[1].quality, is(0));
    }
}
