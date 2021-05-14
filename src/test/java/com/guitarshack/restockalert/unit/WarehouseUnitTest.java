package com.guitarshack.restockalert.unit;

import com.guitarshack.restockalert.Network;
import com.guitarshack.restockalert.Product;
import com.guitarshack.restockalert.WarehouseTestBase;
import retrofit2.Call;

public class WarehouseUnitTest extends WarehouseTestBase {

    @Override
    public Network getNetwork() {
        return new Network() {
            @Override
            public <T> T getData(Call<T> call) {
                return (T) new Product(811,0,"",0,0,0);
            }
        };
    }

}
