package com.magasin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] itemsOrigine = new Item[]{
                new Item("foo", 5, 10),
                new Item("foo", 5, 0),
                new Item("foo", -1, 10),
                new Item("Comté", 2, 10),
                new Item("Comté", 2, 50),
                new Item("Comté", -1, 50),
                new Item("Comté", -1, 10),
                new Item("Pass VIP Concert", 12, 10),
                new Item("Pass VIP Concert", 12, 50),
                new Item("Pass VIP Concert", 9, 10),
                new Item("Pass VIP Concert", 9, 50),
                new Item("Pass VIP Concert", 4, 10),
                new Item("Pass VIP Concert", 4, 50),
                new Item("Pass VIP Concert", 1, 10),
                new Item("Kryptonite", 5, 80)
        };
        Item[] itemsRefacto = new Item[]{
                new Item("foo", 5, 10),
                new Item("foo", 5, 0),
                new Item("foo", -1, 10),
                new Item("Comté", 2, 10),
                new Item("Comté", 2, 50),
                new Item("Comté", -1, 50),
                new Item("Comté", -1, 10),
                new Item("Pass VIP Concert", 12, 10),
                new Item("Pass VIP Concert", 12, 50),
                new Item("Pass VIP Concert", 9, 10),
                new Item("Pass VIP Concert", 9, 50),
                new Item("Pass VIP Concert", 4, 10),
                new Item("Pass VIP Concert", 4, 50),
                new Item("Pass VIP Concert", 1, 10),
                new Item("Kryptonite", 5, 80)
        };

        Magasin app = new Magasin(itemsOrigine);
        MagasinRefacto app2 = new MagasinRefacto(itemsRefacto);
        for (int day = 0; day < 20; day++) {
            app.updateQuality();
            app2.updateQuality();

            String snapLegacy = snapshot(itemsOrigine);
            String snapRefacto = snapshot(itemsRefacto);

            assertEquals(snapLegacy, snapRefacto, "Mismatch au jour " + day);
        }
    }

        private String snapshot(Item[] items) {
            StringBuilder sb = new StringBuilder();
            for (Item item : items) {
                sb.append(item.name)
                        .append(", sellIn=").append(item.sellIn)
                        .append(", quality=").append(item.quality)
                        .append("\n");
            }
            return sb.toString();
        }
}

