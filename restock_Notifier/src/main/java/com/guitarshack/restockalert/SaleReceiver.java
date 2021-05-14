package com.guitarshack.restockalert;

public class SaleReceiver {

    private final RestockAlert reStockAlert;
    private Warehouse warehouse;
    private ReStockCalculator reStockCalculator;

    public SaleReceiver(RestockAlert reStockAlert, Warehouse warehouse, ReStockCalculator reStockCalculator) {
        this.reStockAlert = reStockAlert;
        this.warehouse = warehouse;
        this.reStockCalculator = reStockCalculator;
    }

    public void onSale(int productId, int quantity) {
        Product product = warehouse.getProduct(productId);
        int restockLevel = reStockCalculator.calculateReStockLevel(product);
        if (needsRestocking(quantity, product, restockLevel) && !isOnOrder(product, restockLevel)) {
            String notificationString = product.formatNotification();
            reStockAlert.send(notificationString);
        }
    }

    private boolean isOnOrder(Product product, int restockLevel) {
        return product.getStock() <= restockLevel;
    }

    private boolean needsRestocking(int quantity, Product product, int restockLevel) {
        return restockLevel >= product.getStock() - quantity;
    }

}
