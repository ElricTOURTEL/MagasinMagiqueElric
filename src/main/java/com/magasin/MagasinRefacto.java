package com.magasin;

public class MagasinRefacto {
    Item[] items;

    public MagasinRefacto(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (Item item : items) {
            // rentre si cas specifique
            if (item.name.equals("Pass VIP Concert") || item.name.equals("Comté") || item.name.equals("Kryptonite")) {
                // rentre si Kryptonite
                if (item.name.equals("Kryptonite")) {
                    continue;
                }
                // rentre si Comté
                if (item.name.equals("Comté")) {
                    if(item.sellIn > 0){
                        item.quality = Math.min(50, item.quality+1);
                    }
                    else{
                        item.quality = Math.min(50, item.quality+2);
                    }

                }
                // Rentre si Pass Vip Concert
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
                // hors cas specifique
            } else {
                    if (item.quality > 0) {
                        if (item.sellIn <= 0) {
                            item.quality = Math.max(0, item.quality - 2);
                        } else {
                            item.quality--;
                        }
                    }
                }
                item.sellIn--;
            }

        }
    }

