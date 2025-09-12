package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0),
                new Item("Comté", 0, 0),
                new Item("Pass VIP Concert", 0, 0),
                new Item("Kryptonite", 0, 80),
                new Item("Kryptonite", 0, 0),
                new Item("Kryptonite", 5, -50),
        };
        Magasin app = new Magasin(items);
        app.updateQuality();
        for(int i = 0; i<items.length;i++){
            assertEquals(items[i].name, app.items[i].name);
        }
    }
}
