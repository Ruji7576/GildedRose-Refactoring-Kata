# Gilded Rose

This Java application implements the inventory management system for the Gilded Rose Inn. It handles the update of item qualities based on different product types.

## Overview

The `GildedRose` class manages an array of `Item` objects, updating their quality and sell-in days based on their specific product type. The following product types are handled:

- **Aged Brie**: Increases in quality as it ages.
- **Backstage passes to a TAFKAL80ETC concert**: Quality increases as the concert approaches, with special behavior near the sell-in date.
- **Sulfuras, Hand of Ragnaros**: Legendary item with no sell-in or quality changes.
- **Conjured Mana Cake**: Degrades in quality twice as fast as regular items.

Other items follow a default degradation pattern in quality as their sell-in days decrease.

## Implementation Details

The `GildedRose` class includes methods to update each type of product based on its specific rules. These methods are encapsulated to maintain clarity and modularity:

- `updateQuality`: Iterates through each item and applies the respective update based on its type.
- Private methods:
  - `updateAgedBrieProduct`
  - `updateConcertProduct`
  - `updateConspiratorsProducts`
  - `updateDefaultProducts`
  
  These methods handle specific logic for updating each type of item's quality and sell-in days.

## Usage

To use this application, instantiate the `GildedRose` class with an array of `Item` objects, where each `Item` represents a specific product with a name, sell-in days, and quality. Call the `updateQuality` method to simulate the passage of one day, which updates all items in the inventory.
