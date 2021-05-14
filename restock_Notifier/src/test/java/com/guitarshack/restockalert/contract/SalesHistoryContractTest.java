package com.guitarshack.restockalert.contract;

import com.guitarshack.restockalert.HttpNetwork;
import com.guitarshack.restockalert.Network;
import com.guitarshack.restockalert.SalesHistoryTestBase;

public class SalesHistoryContractTest extends SalesHistoryTestBase {

    @Override
    public Network getNetwork() {
        return new HttpNetwork();
    }

}
