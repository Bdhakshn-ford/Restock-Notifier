package com.guitarshack.restockalert;

import java.util.Date;

public interface SalesHistory {
    int getSalesForDateRange(int productId, Date startDate, Date endDate);
}
