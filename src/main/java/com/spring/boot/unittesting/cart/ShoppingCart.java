package com.spring.boot.unittesting.cart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items = new HashMap<>();

    // Add item to cart
    public void addItem(Item item) {
        if (items.containsKey(item.getName())) {
            items.get(item.getName()).addQuantity(item.getQuantity());
        } else {
            items.put(item.getName(), item);
        }
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    // Remove item completely from cart
    public void removeItem(String name) {
        items.remove(name);
    }

    // Reduce item quantity (remove only some units)
    public void reduceItemQuantity(String name, int quantity) {
        if (!items.containsKey(name)) {
            throw new IllegalArgumentException("Item not found in cart.");
        }
        Item item = items.get(name);
        item.reduceQuantity(quantity);
        if (item.getQuantity() == 0) {
            items.remove(name);
        }
    }

    // Get total price of all items
    public double getTotalPrice() {
        double total = 0.0;
        for (Item item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    // Get number of items (unique products)
    public int getItemCount() {
        return items.size();
    }

    // Clear the cart
    public void clearCart() {
        items.clear();
    }

    // For displaying cart contents
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shopping Cart:\n");
        for (Item item : items.values()) {
            sb.append(item.getName())
                    .append(" - ")
                    .append(item.getQuantity())
                    .append(" x $")
                    .append(item.getPrice())
                    .append("\n");
        }
        sb.append("Total: $").append(getTotalPrice());
        return sb.toString();
    }
}
