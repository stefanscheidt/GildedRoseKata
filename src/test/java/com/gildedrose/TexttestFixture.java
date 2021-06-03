package com.gildedrose;

import java.io.FileWriter;
import java.io.PrintWriter;

public class TextTestFixture {

    public static final int DAYS = 30;
    public static final String FILENAME = "./testtext/stdout.txt";

    public static void printFixture(PrintWriter writer) {
        var fixture = new TextTestFixture();
        writer.println("OMGHAI!");
        for (int i = 0; i <= DAYS; i++) {
            writer.println("-------- day " + i + " --------");
            writer.println("name, sellIn, quality");
            for (Item item : fixture.items) writer.println(item);
            writer.println();
            writer.flush();
            fixture.gildedRose.updateQuality();
        }
    }

    public static void main(String[] args) throws Exception {
        var writer = new PrintWriter(new FileWriter(FILENAME));
        printFixture(writer);
    }

    private final Item[] items;
    private final GildedRose gildedRose;

    private TextTestFixture() {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
        gildedRose = new GildedRose(items);
    }

}
