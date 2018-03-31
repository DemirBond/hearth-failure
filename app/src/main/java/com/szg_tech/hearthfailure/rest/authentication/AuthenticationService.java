package com.szg_tech.hearthfailure.rest.authentication;

import com.szg_tech.hearthfailure.rest.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public interface AuthenticationService {

    @POST("token")
    Call<LoginResponse> login(@Body String loginBody);


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api/account/register")
    Call<Void> register(@Body String registerBody);


    @POST("api/account/Activate")
    Call<Void> activate(@Body String activateBody);
}
