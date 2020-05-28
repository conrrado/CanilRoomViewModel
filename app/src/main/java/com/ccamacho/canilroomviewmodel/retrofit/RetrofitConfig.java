package com.ccamacho.canilroomviewmodel.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit config;

    public RetrofitConfig() {
        String baseUrl = "https://api.thedogapi.com/v1/";
        config = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public CanilAPI getCanilAPI() {
        return config.create(CanilAPI.class);
    }
}
