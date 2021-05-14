package com.guitarshack.restockalert;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SalesHistoryService {

    @GET("/sales?action=total")
    Call<TotalSales> getSalesHistory(@Query("productId") int productId, @Query("startDate") String startDate, @Query("endDate") String endDate);
}
