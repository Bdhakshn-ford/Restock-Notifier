package com.guitarshack.restockalert;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WarehouseService {

    @GET("product")
    Call<Product> getProduct(@Query("id") int id);
}
