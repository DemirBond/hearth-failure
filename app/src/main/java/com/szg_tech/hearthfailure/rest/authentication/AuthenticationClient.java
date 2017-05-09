package com.szg_tech.hearthfailure.rest.authentication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class AuthenticationClient {

    private static final String BASE_URL = "http://www.hearthfailure.com/api/";
    private AuthenticationService authenticationService;

    public AuthenticationClient() {
        Gson gson = new GsonBuilder()
                .create();


        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();


        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        authenticationService = restAdapter.create(AuthenticationService.class);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
