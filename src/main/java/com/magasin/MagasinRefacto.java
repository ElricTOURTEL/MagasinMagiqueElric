package com.magasin;

public class MagasinRefacto {
    Item[] items;

    public MagasinRefacto(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Pass VIP Concert") || item.name.equals("Comté") || item.name.equals("Kryptonite")) {
                if (item.name.equals("Kryptonite")) {
                    continue;
                }

                if (item.name.equals("Comté")) {
                    item.quality = Math.min(50, item.quality+1);
                }
                if (item.name.equals("Pass VIP Concert")) {
                    if (item.sellIn <= 0) {
                        item.quality = 0;
                    } else if (item.sellIn <= 5) {
                        item.quality = Math.min(50, item.quality + 3);
                    } else if (item.sellIn <= 10) {
                        item.quality = Math.min(50, item.quality + 2);
                    } else {
                        item.quality = Math.min(50, item.quality + 1);
                    }
                }
            } else {
                    if (item.quality > 0) {
                        if (item.sellIn < 0) {
                            item.quality = item.quality - 2;
                        } else {
                            item.quality--;
                        }
                    }
                }
                item.sellIn--;
            }

        }
    }

