package com.guitarshack.restockalert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class WarehouseTestBase {
    @Test
    public void returnsProductById(){

        Warehouse warehouse = new ProductWarehouse(getNetwork(), "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/");

        assertEquals(811, warehouse.getProduct(811).getId());
    }

    public abstract Network getNetwork();
}
