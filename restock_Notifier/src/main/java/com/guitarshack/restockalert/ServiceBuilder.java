package com.guitarshack.restockalert;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    public ServiceBuilder() {
    }

    <T> T buildService(Class<T> serviceType, String baseUrl) {
        Retrofit retrofitClient = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitClient.create(serviceType);
    }
}