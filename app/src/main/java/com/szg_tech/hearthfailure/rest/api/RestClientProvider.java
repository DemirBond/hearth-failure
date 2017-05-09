package com.szg_tech.hearthfailure.rest.api;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class RestClientProvider {

    private static RestClient restClient;

    public static RestClient get() {
        if (restClient == null) {
            throw new IllegalStateException("Call init before getting restClient");
        }
        return restClient;
    }

    public static void init(String token) {

        restClient = new RestClient(token);
    }

}
