package com.guitarshack.restockalert;

public class Product {
    private int id;
    private int stock;
    private String description;
    private int minimumOrder;
    private int rackSpace;
    private int leadTime;

    public Product(int id, int stock, String description, int minimumOrder, int rackSpace, int leadTime) {
        this.id = id;

        this.stock = stock;
        this.description = description;
        this.minimumOrder = minimumOrder;
        this.rackSpace = rackSpace;
        this.leadTime = leadTime;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }

    String formatNotification() {
        String description = this.description;
        int minimumOrder = this.minimumOrder;
        int rackSpace = this.rackSpace;
        return "\"Please reorder product " + getId() + " (" + description + ")\n" + "\n" + "Minimum order: " + minimumOrder + ", Rack space: " + rackSpace + "\"";
    }

    public int getLeadTime() {
        return leadTime;
    }
}
