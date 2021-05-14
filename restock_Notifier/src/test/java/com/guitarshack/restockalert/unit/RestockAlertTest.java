package com.guitarshack.restockalert.unit;

import com.guitarshack.restockalert.*;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RestockAlertTest {

    private Warehouse warehouse;
    private RestockAlert reStockAlert;
    private ReStockCalculator reStockCalculator;
    private SaleReceiver saleReceiver;

    public void setUp(int stock) {
        reStockAlert = mock(RestockAlert.class);
        warehouse = (productId) -> new Product(757, stock, "Fender Player Stratocaster w/ Maple Fretboard in Buttercream", 10, 20, 14);
        reStockCalculator = (product) -> 5;
        saleReceiver = new SaleReceiver(reStockAlert, warehouse, reStockCalculator);
    }

    @Test
    public void minimumStockLevelNotHit() {
        setUp(10);

        saleReceiver.onSale(757, 4);

        verify(reStockAlert, never()).send(any());
    }


    @Test
    public void alertWhenMinimumLevelHit() {
        setUp(10);

        saleReceiver.onSale(757, 5);

        verify(reStockAlert).send("\"Please reorder product 757 (Fender Player Stratocaster w/ Maple Fretboard in Buttercream)\n" +
                "\n" +
                "Minimum order: 10, Rack space: 20\"");
    }

    @Test
    public void noAlertWhenAlreadyBelowMinimumLevelHit() {
        setUp(5);

        saleReceiver.onSale(757, 1);

        verify(reStockAlert, never()).send(any());
    }
}