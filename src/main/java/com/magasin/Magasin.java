package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Comté") // si différent de comté ou pass VIP concert
                    && !items[i].name.equals("Pass VIP Concert")) {
                if (items[i].quality > 0) { // si la qualité est supérieur à 0
                    if (!items[i].name.equals("Kryptonite")) { // si l'item est différent de Kryptonyte
                        items[i].quality = items[i].quality - 1; // on diminue la qualité de 1
                    }
                }
            } else { // si le nom est comté ou pass vip concert
                if (items[i].quality < 50) { //si la qualité des items autre que comté et pass vip est strictement inférieur à 50
                    items[i].quality = items[i].quality + 1; // on augmente la qualité de 1

                    if (items[i].name.equals("Pass VIP Concert")) { // si c'est pass vip specifiquement
                        if (items[i].sellIn < 11) { // et qu'il reste moins de 11 jours
                            if (items[i].quality < 50) { // et que la qualité est strictement inférieur à 50
                                items[i].quality = items[i].quality + 1; // alors on augmente la qualité de 1
                            }
                        }

                        if (items[i].sellIn < 6) { // s'il reste moins 6 jours
                            if (items[i].quality < 50) { // qualité strictement inférieur à 50
                                items[i].quality = items[i].quality + 1; // augmente de qualité de 1
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Kryptonite")) { // si items différent de krypto
                items[i].sellIn = items[i].sellIn - 1; // on réduit les jours de 1
            }

            if (items[i].sellIn < 0) { // si le nombre de jours restant est strictement inférieur à 0
                if (!items[i].name.equals("Comté")) { // si le nom est différent de Comté
                    if (!items[i].name.equals("Pass VIP Concert")) { // si le nom est différent de Pass Vip
                        if (items[i].quality > 0) { // si la qualité est supérieur à 0
                            if (!items[i].name.equals("Kryptonite")) { // si le nom est différent de Krypto
                                items[i].quality = items[i].quality - 1; // on réduit la qualité de 1
                            }
                        }
                    } else { // si nom égal pass vip
                        items[i].quality = items[i].quality - items[i].quality; // quality = 0
                    }
                } else { // si nom égal Comté
                    if (items[i].quality < 50) { // Qualité strictement inférieur à 50
                        items[i].quality = items[i].quality + 1; // augmentation qualité de 1
                    }
                }
            }
        }
    }
}
