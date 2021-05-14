package com.guitarshack.restockalert.unit;

import com.guitarshack.restockalert.RestockCalculatorTestBase;
import com.guitarshack.restockalert.SalesHistory;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.*;

public class RestockCalculatorWithOneYearsSaleHistoryTest extends RestockCalculatorTestBase {

    @Override
    public void createSalesHistory() {
        salesHistory = mock(SalesHistory.class);
        when(salesHistory.getSalesForDateRange(anyInt(), anyObject(), anyObject())).thenReturn(10);
    }

    @Override
    public Date expectedStartDate() {
        return createDate(2018, Calendar.DECEMBER, 11);
    }

    @Override
    public Date expectedEndDate() {
        return createDate(2018, Calendar.DECEMBER, 24);
    }

}
