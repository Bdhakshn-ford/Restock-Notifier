package com.guitarshack.restockalert.unit;

import com.guitarshack.restockalert.Network;
import com.guitarshack.restockalert.SalesHistoryTestBase;
import com.guitarshack.restockalert.TotalSales;
import retrofit2.Call;

public class SalesHistoryUnitTest extends SalesHistoryTestBase {


    @Override
    public Network getNetwork() {
        return new Network() {
            @Override
            public <T> T getData(Call<T> call) {
                return (T) new TotalSales(20);
            }
        };
    }
}
