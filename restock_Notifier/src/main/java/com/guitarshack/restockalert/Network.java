package com.guitarshack.restockalert;

import retrofit2.Call;

import java.io.IOException;

public interface Network {
    <T> T getData(Call<T> call);
}
