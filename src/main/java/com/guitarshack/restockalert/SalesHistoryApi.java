package com.guitarshack.restockalert;

import retrofit2.Call;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesHistoryApi implements SalesHistory {
    private final Network network;
    private final ServiceBuilder serviceBuilder = new ServiceBuilder();
    private final String baseUrl;

    public SalesHistoryApi(Network network, String baseUrl) {
        this.network = network;
        this.baseUrl = baseUrl;
    }

    @Override
    public int getSalesForDateRange(int productId, Date startDate, Date endDate) {
        SalesHistoryService service = serviceBuilder.buildService(SalesHistoryService.class, baseUrl);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("M/d/yyyy");

        Call<TotalSales> totalSales = service.getSalesHistory(productId, dateFormatter.format(startDate), dateFormatter.format(endDate));

        return network.getData(totalSales).getTotal();
    }
}
