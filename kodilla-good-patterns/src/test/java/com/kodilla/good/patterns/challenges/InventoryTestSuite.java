package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class InventoryTestSuite {
    @Test
    public void testAddProduct() {
        //Given
        Product toothPaste = new Toothpaste("1", "toothpaste", "Sensodyne",
                "whitening", LocalDateTime.of(2025, 12, 01, 12, 0));
        Product fallout3 = new Game("2", "game", "Fallout 3", "rpg");

        //When
        Inventory.addProduct(toothPaste, fallout3);
        Inventory.addProduct(toothPaste);

        //Then
        Assert.assertEquals(2, Inventory.getSetOfProducts().size());
        Assert.assertTrue(Inventory.containsProduct(toothPaste));
        Assert.assertTrue(Inventory.containsProduct(fallout3));
    }

    @Test
    public void testDeleteProduct() {
        //Given
        Product toothPaste = new Toothpaste("1", "toothpaste", "Sensodyne",
                "whitening", LocalDateTime.of(2025, 12, 01, 12, 0));
        Product fallout3 = new Game("2", "game", "Fallout 3", "rpg");
        Inventory.addProduct(toothPaste, fallout3);

        //When
        Inventory.deleteProduct(toothPaste);

        //Then
        Assert.assertFalse(Inventory.containsProduct(toothPaste));
        Assert.assertTrue(Inventory.containsProduct(fallout3));
    }
}
