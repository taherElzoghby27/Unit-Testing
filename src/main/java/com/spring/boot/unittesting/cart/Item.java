package com.spring.boot.unittesting.cart;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }
        this.quantity += qty;
    }

    public void reduceQuantity(int qty) {
        if (qty < 0 || qty > quantity) {
            throw new IllegalArgumentException("Invalid quantity to reduce.");
        }
        this.quantity -= qty;
    }
}
