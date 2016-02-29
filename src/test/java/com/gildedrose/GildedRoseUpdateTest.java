package com.gildedrose;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseUpdateTest {

	private Item normalItem;
	private Item agedBrie;
	private Item sulfuras;
	private Item backstagePass;
	private Item conjuredItem;
	private GildedRose gildedRose;

	@Before
	public void setUp() throws Exception {
		normalItem = new Item("+5 Dexterity Vest", 10, 20);
		agedBrie = new Item("Aged Brie", 10, 20);
		sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 20);
		backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
		conjuredItem = new Item("Conjured Mana Cake", 10, 20);
		Item[] items = new Item[]{normalItem, agedBrie, sulfuras, backstagePass, conjuredItem};
		gildedRose =   new GildedRose(items);
	}

	@Test
	public void sellInDateIsLowered() {
		gildedRose.updateQuality();
		assertThat(normalItem.sellIn, is(9));
		assertThat(agedBrie.sellIn, is(9));
		assertThat(backstagePass.sellIn, is(10));
	}

	@Test
	public void qualityIsLowered() {
		gildedRose.updateQuality();
		assertThat(normalItem.quality, is(19));
	}

	@Test
	public void qualityDegradesTwiceAsFastAfterSellDateIsReached() {
		ageByDays(10);
		gildedRose.updateQuality();
		assertThat(normalItem.quality, is(8));
	}

	@Test
	public void qualityIsNeverNegative() {
		ageByDays(21);
		assertThat(normalItem.quality, is(0));
	}

	@Test
	public void agedBrieIncreasesQuality() {
		gildedRose.updateQuality();
		assertThat(agedBrie.quality, is(21));
	}

	@Test
	public void qualityIsNeverMoreThan50() {
		ageByDays(31);
		assertThat(agedBrie.quality, is(50));
	}

	@Test
	public void sulfurasIsNeverToBeSold() {
		gildedRose.updateQuality();
		assertThat(sulfuras.sellIn, is(10));
	}

	@Test
	public void sulfurasNeverDecreasesQuality() {
		gildedRose.updateQuality();
		assertThat(sulfuras.quality, is(20));
	}

	@Test
	public void backstagePassesIncreaseQuality() {
		gildedRose.updateQuality();
		assertThat(backstagePass.quality, is(21));
	}

	@Test
	public void backstageQualityIncreasesByTwoWhen10DaysAreLeft() {
		ageByDays(1);
		gildedRose.updateQuality();
		assertThat(backstagePass.quality, is(23));
	}

	@Test
	public void backstageQualityIncreasesByThreeWhen5DaysAreLeft() {
		ageByDays(6);
		gildedRose.updateQuality();
		assertThat(backstagePass.quality, is(34));
	}

	@Test
	public void backstageQualityIsZeroWhenSellInIsReached() {
		ageByDays(15);
		gildedRose.updateQuality();
		assertThat(backstagePass.quality, is(0));
	}

	@Test
	@Ignore
	public void conjuredItemsDecreaseQualityByTwo() {
		gildedRose.updateQuality();
		assertThat(conjuredItem.quality, is(18));
	}


	private void ageByDays(int daysToAge) {
		for (int i = 0; i< daysToAge; i++) {
			gildedRose.updateQuality();
		}
	}


}
