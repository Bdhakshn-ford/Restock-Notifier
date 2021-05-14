package com.guitarshack.restockalert;

import retrofit2.Call;

import java.io.IOException;
import java.util.Objects;

public class HttpNetwork implements Network {

    @Override
    public <T> T getData(Call<T> call) {
        try {
            return Objects.requireNonNull(call.execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}