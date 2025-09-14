package com.spring.boot.unittesting;

import com.spring.boot.unittesting.cart.Item;
import com.spring.boot.unittesting.cart.ShoppingCart;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTest {
    private ShoppingCart cart;
    //given_when_then

    @Before
    public void setUpBeforeClass() {
        cart = new ShoppingCart();
    }

    //all test cases for item
    @Test
    public void givenItem_whenAddingItem_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        String itemName = item.getName();
        assertEquals("item name not correct", "item 1", itemName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenItem_whenAddingItem_thenException() {
        new Item("item 1", -2000, 2);
    }

    @Test
    public void givenItem_whenGettingItemQuantity_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        int itemQuantities = item.getQuantity();
        assertEquals("item quantity not correct", 2, itemQuantities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenItem_whenAddingNegativeQuantity_thenException() {
        new Item("item 1", -2000, -2);
    }

    @Test
    public void whenGettingItemQuantity_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        item.addQuantity(5);
        int itemQuantities = item.getQuantity();
        assertEquals("item quantity not correct", 7, itemQuantities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddingNegativeQuantity_thenException() {
        Item item = new Item("item 1", 2000, 2);
        item.addQuantity(-5);
    }

    @Test
    public void whenReduceQuantity_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        item.reduceQuantity(2);
        int itemQuantities = item.getQuantity();
        assertEquals("item quantity not correct", 0, itemQuantities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenReduceNegativeQuantity_thenException() {
        Item item = new Item("item 1", 2000, 2);
        item.reduceQuantity(5);
    }

    @Test
    public void whenAddingItem_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        cart.addItem(item);
        Item cartItem = cart.getItem("item 1");
        //assertEquals("item name not correct", "item 1", cartItem.getName());
        assertNotNull("item should not be not null", cartItem);
    }

    @Test
    public void whenRemoveItem_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        cart.removeItem(item.getName());
        Item cartItem = cart.getItem("item 1");
        //assertEquals("item name not correct", "item 1", cartItem.getName());
        assertNull("item should not be null", cartItem);
    }

    @Test
    public void whenReduceItemQuantityEmpty_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        cart.addItem(item);
        cart.reduceItemQuantity("item 1", 2);
        Item cartItem = cart.getItem("item 1");
        assertNull("item should not be null", cartItem);
    }

    @Test
    public void whenReduceItemQuantity_thenCorrect() {
        Item item = new Item("item 1", 2000, 2);
        cart.addItem(item);
        cart.reduceItemQuantity("item 1", 1);
        Item cartItem = cart.getItem("item 1");
        assertEquals("item quantities equals", 1, cartItem.getQuantity());
    }

    @Test
    public void givenAddingItems_whenTotalPrice_thenCorrect() {
        Item item1 = new Item("item 1", 2000, 2);
        Item item2 = new Item("item 2", 3000, 2);
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals("item quantities equals", 10000, cart.getTotalPrice(), 0.0001);
    }

    @Test
    public void givenRemoveItems_whenTotalCounts_thenCorrect() {
        Item item1 = new Item("item 1", 2000, 2);
        Item item2 = new Item("item 2", 3000, 2);
        cart.addItem(item1);
        cart.addItem(item2);
        int count = cart.getItemCount();
        assertEquals("item counts must equals", 2, count);
    }

    @Test
    public void givenAddingItems_whenClearCart_thenCorrect() {
        Item item1 = new Item("item 1", 2000, 2);
        Item item2 = new Item("item 2", 3000, 2);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.clearCart();
        assertEquals("item must be empty", 0, cart.getItemCount());
    }
}
