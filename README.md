# Gilded Rose Kata

This Repo is based on [this one](https://github.com/inevs/GildedRoseKata) from Sven Günther.

The Kata itself is a Java-port from [Emilie Bache's Github Repository](https://github.com/emilybache/GildedRose-Refactoring-Kata).

The Kata was originally created by Terry Hughes (http://twitter.com/#!/TerryHughes).
It is already on GitHub [here](https://github.com/NotMyself/GildedRose).
See also Bobby Johnson's [description](http://iamnotmyself.com/2011/02/13/refactor-this-the-gilded-rose-kata/) of the kata.

To build the project and run the test on the command line, use `./gradlew build`.

The tests from [`GildedRoseTest`](./src/test/java/com/gildedrose/GildedRoseTest.java) are taken from this [Gist](https://gist.github.com/xpmatteo/5243745.js).

You might want to delete these test and write the for yourself based on [the requirements](#gilded-rose-requirements) befor you start with the refactoring.

The [`TextTest`](./src/test/java/com/gildedrose/TestText.java) is inspired by [text-based approval testing](https://github.com/texttest/texttest).
This test does not reveal any domain logic but does provide (almost) 100% coverage.
You can use this test as a safty net and try to discover the domain logic only by applying structural refactorings.

## Gilded Rose Requirements

These requirements are taken from [Emilie Bache's Github Repository](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt).

--- 

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can begin selling a new category of items. First an introduction to our system:

*   All items have a SellIn value which denotes the number of days we have to sell the item
*   All items have a Quality value which denotes how valuable the item is
*   At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

*   Once the sell by date has passed, Quality degrades twice as fast
*   The Quality of an item is never negative
*   "Aged Brie" actually increases in Quality the older it gets
*   The Quality of an item is never more than 50
*   "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
*   "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
    but Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

*   "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the `UpdateQuality` method and add any new code as long as everything
still works correctly. **However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership.** (You can make the `UpdateQuality` method and Items property static if you like, we'll cover
for you.)

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.

---
