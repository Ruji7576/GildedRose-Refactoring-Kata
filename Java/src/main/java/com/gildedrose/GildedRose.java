package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            countQualityHasDays(item);
            lessDays(item);
            countQualityHasNotDays(item);
        }
    }

    private void countQualityHasDays(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            lessQualityMini(item);
        }
        if(item.name.equals("Aged Brie")) {
            increaseQualityMini(item);
        }
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityConcert(item);
        }
    }

    private void countQualityHasNotDays(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQualityMini(item);
            }
            if (!item.name.equals("Aged Brie") && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                lessQualityMini(item);
            }
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = item.quality - item.quality;
            }
        }
    }

    private void lessDays(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn -= 1;
        }
    }

    private void lessQualityMini(Item item) {
        if (item.quality > 0) {
            int less = 1;
            if (item.name.equals("Conspirators")) {
                less = 2;
            }
            item.quality -= less;
        }
    }

    private void increaseQualityMini(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void increaseQualityConcert(Item item) {
            increaseQualityMini(item);
        if (item.sellIn <= 10) {
            increaseQualityMini(item);
        }
        if (item.sellIn <= 5) {
            increaseQualityMini(item);
        }
    }
}
