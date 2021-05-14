package com.guitarshack.restockalert;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public abstract class SalesHistoryTestBase {
    @Test
    public void getTotalSalesForGivenDateRange(){

        SalesHistory salesHistory = new SalesHistoryApi(getNetwork(), "https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JULY, 17);
        Date startDate = calendar.getTime();
        calendar.set(2019, Calendar.JULY, 27);
        Date endDate = calendar.getTime();

        assertEquals(20, salesHistory.getSalesForDateRange(811, startDate, endDate));
    }

    public abstract Network getNetwork();
}
