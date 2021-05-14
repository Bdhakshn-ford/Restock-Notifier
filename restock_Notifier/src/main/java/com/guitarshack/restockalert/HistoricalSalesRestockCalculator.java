package com.guitarshack.restockalert;

import java.util.Calendar;
import java.util.Date;

public class HistoricalSalesRestockCalculator implements ReStockCalculator {
    private final Today today;
    private final SalesHistory salesHistory;
    private Date startDate;
    private Date endDate;

    public HistoricalSalesRestockCalculator(Today today, SalesHistory salesHistory) {
        this.today = today;
        this.salesHistory = salesHistory;
    }

    @Override
    public int calculateReStockLevel(Product product) {
        Calendar calendar = Calendar.getInstance();
        setLastYearDateRange(product, calendar);


        int lastYearSales = salesHistory.getSalesForDateRange(product.getId(), startDate, endDate);

        if (lastYearSales == 0) {
            setRecentSalesDateRange(product, calendar);
            return salesHistory.getSalesForDateRange(product.getId(), startDate, endDate);
        }

        return lastYearSales;

    }

    private void setRecentSalesDateRange(Product product, Calendar calendar) {
        calendar.setTime(today.get());
        endDate = calendar.getTime();
        calendar.add(Calendar.DATE, -(product.getLeadTime() - 1));
        startDate = calendar.getTime();
    }

    public void setLastYearDateRange(Product product, Calendar calendar) {
        calendar.setTime(today.get());
        calendar.add(Calendar.YEAR, -1);
        startDate = calendar.getTime();
        calendar.add(Calendar.DATE, product.getLeadTime() - 1);
        endDate = calendar.getTime();
    }
}
