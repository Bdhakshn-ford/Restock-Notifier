package com.guitarshack.restockalert.integration;

import com.guitarshack.restockalert.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GuitarShackIntegrationTest {

    @Test
    public void sendsAlert(){

        RestockAlert alert = mock(RestockAlert.class);
        SaleReceiver saleReceiver = new SaleReceiver(alert,
                new ProductWarehouse(
                        new HttpNetwork(),
                        "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/"),
                new HistoricalSalesRestockCalculator(() -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2020,Calendar.JULY,1);
                    Date date = calendar.getTime();
                    return date;
                },
                        new SalesHistoryApi(
                                new HttpNetwork(),
                                "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/")));

        saleReceiver.onSale(811,53);

        verify(alert).send(any());
    }

}
