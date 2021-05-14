package com.guitarshack.restockalert;

import retrofit2.Call;

public class ProductWarehouse implements Warehouse {
    private final String baseUrl;
    private final Network network;
    private final ServiceBuilder serviceBuilder = new ServiceBuilder();

    public ProductWarehouse(Network network, String baseUrl) {
        this.network = network;
        this.baseUrl = baseUrl;
    }

    @Override
    public Product getProduct(int id) {
        WarehouseService warehouseService = serviceBuilder.buildService(WarehouseService.class, baseUrl);
        Call<Product> productCall = warehouseService.getProduct(id);
        return network.getData(productCall);
    }
}
