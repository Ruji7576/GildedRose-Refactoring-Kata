package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrieProduct(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateConcertProduct(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Conjured Mana Cake":
                    updateConspiratorsProducts(item);
                    break;
                default:
                    updateDefaultProducts(item);
            }
        }
    }

    private void updateAgedBrieProduct(Item item) {
        reduceDays(item);
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateConcertProduct(Item item) {
        reduceDays(item);
        increaseQualityConcert(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateConspiratorsProducts(Item item) {
        reduceDays(item);
        for(int i = 0 ; i < 2 ; i++ ) {
            reduceQuality(item);
            if (item.sellIn < 0) {
                reduceQuality(item);
            }
        }
    }

    private void updateDefaultProducts(Item item) {
        reduceDays(item);
        reduceQuality(item);
        if (item.sellIn < 0) {
            reduceQuality(item);
        }
    }

    private void reduceDays(Item item) {
            item.sellIn -= 1;
    }

    private void reduceQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void increaseQualityConcert(Item item) {
            increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
    }
}
