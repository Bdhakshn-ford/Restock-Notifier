package com.guitarshack.restockalert.contract;

import com.guitarshack.restockalert.HttpNetwork;
import com.guitarshack.restockalert.Network;
import com.guitarshack.restockalert.WarehouseTestBase;

public class WarehouseContractTest extends WarehouseTestBase {
    @Override
    public Network getNetwork() {
        return new HttpNetwork();
    }
}
