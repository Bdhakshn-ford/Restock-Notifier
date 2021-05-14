package com.guitarshack.restockalert;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public abstract class RestockCalculatorTestBase {
    protected SalesHistory salesHistory;
    private ReStockCalculator restockCalculator;
    private Product product;
    private Calendar calendar = Calendar.getInstance();

    @Before
    public void setUp() {
        Today today = () -> {
            calendar.set(2019, Calendar.DECEMBER, 11, 00, 00, 00);
            return calendar.getTime();
        };

        createSalesHistory();

        restockCalculator = new HistoricalSalesRestockCalculator(today, salesHistory);
        product = new Product(757, 0,"",0,0,14);
    }

    public abstract void createSalesHistory();

    public Date createDate(int year, int month, int date) {
        calendar.set(year, month, date, 00,00,00);

        return calendar.getTime();
    }

    public abstract Date expectedStartDate();

    public abstract Date expectedEndDate();

    @Test
    public void returnsTotalSalesForDateRange(){
        assertEquals(10, restockCalculator.calculateReStockLevel(product));
    }

    @Test
    public void usesCorrectStartDate(){
        Date date = expectedStartDate();

        restockCalculator.calculateReStockLevel(product);

        verify(salesHistory, times(1)).getSalesForDateRange(anyInt(), eq(date), anyObject());
    }

    @Test
    public void usesCorrectEndDate() {
        Date endDate = expectedEndDate();

        restockCalculator.calculateReStockLevel(product);

        verify(salesHistory, times(1)).getSalesForDateRange(anyInt(), anyObject(), eq(endDate));
    }
}
