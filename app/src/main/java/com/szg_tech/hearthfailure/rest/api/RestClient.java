package com.szg_tech.hearthfailure.rest.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class RestClient
{
    private static final String BASE_URL = "http://www.hearthfailure.com/";
    private static ApiService apiService;

    public RestClient(String token) {
        Gson gson = new GsonBuilder()
                .create();

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new AuthenticationInterceptor(token));
        OkHttpClient client = builder.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        apiService = restAdapter.create(ApiService.class);

    }

    public ApiService getApi() {
        return apiService;
    }

}
