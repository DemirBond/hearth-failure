package com.szg_tech.hearthfailure.rest.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginResponse {

    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("error")
    public String error;

    @SerializedName("expires_in")
    public long expiresIn;


    @SerializedName("token_type")
    public String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenWithType() {
        return tokenType + " " + accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isSucceed() {
        if ((error == null || error.isEmpty()) && (accessToken != null || !accessToken.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
