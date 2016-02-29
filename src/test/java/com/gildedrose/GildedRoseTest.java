package com.gildedrose;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    private final String name;
    private final int sellIn;
    private final int quality;
	private final int updatedSellIn;
	private final int updatedQuality;

	@Parameters
    public static List<Object[]> parameters() {
        Object[][] testData = new Object[][] {
                {"+5 Dexterity Vest", 10, 20, 9, 19},
                {"Aged Brie", 2, 0, 1, 1},
                {"Elixir of the Mongoose", 5, 7, 4, 6},
                {"Sulfuras, Hand of Ragnaros", 0, 80, 0, 80},
                {"Sulfuras, Hand of Ragnaros", -1, 80, -1, 80},
                {"Backstage passes to a TAFKAL80ETC concert", 15, 20, 14, 21},
                {"Backstage passes to a TAFKAL80ETC concert", 10, 49, 9, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 5, 49, 4, 50},
                {"Conjured Mana Cake", 3, 6, 2, 4},
        };
        return Arrays.asList(testData);
    }

    public GildedRoseTest(String name, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
		this.updatedSellIn = updatedSellIn;
		this.updatedQuality = updatedQuality;
	}

    @Test
    public void testUpdate() {
		Item item = new Item(name, sellIn, quality);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();
		assertThat(item.sellIn, is(updatedSellIn));
		assertThat(item.quality, is(updatedQuality));
    }

}
