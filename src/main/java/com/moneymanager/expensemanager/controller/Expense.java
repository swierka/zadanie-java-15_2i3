package com.moneymanager.expensemanager.controller;

public class Expense {
    private String name;
    private double price;
    private Category category;

    public Expense(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) { this.category = category;}

    @Override
    public String toString() {
        return "Nazwa:" + name + '\'' +
                ", cena: " + price +
                ", kategoria: " + category;
    }
}

