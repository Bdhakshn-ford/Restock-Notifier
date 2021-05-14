package com.guitarshack.restockalert.unit;

import com.guitarshack.restockalert.RestockCalculatorTestBase;
import com.guitarshack.restockalert.SalesHistory;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RestockCalculatorWithoutOneYearsSalesHistoryTest extends RestockCalculatorTestBase {


    @Override
    public void createSalesHistory() {
        salesHistory = mock(SalesHistory.class);
        when(salesHistory.getSalesForDateRange(anyInt(),anyObject(),anyObject())).thenReturn(0,10);

    }

    @Override
    public Date expectedStartDate() {
        return createDate(2019, Calendar.NOVEMBER, 28);
    }

    @Override
    public Date expectedEndDate() {
        return createDate(2019, Calendar.DECEMBER, 11);
    }
}
