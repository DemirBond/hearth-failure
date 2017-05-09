package com.szg_tech.hearthfailure.rest.requests;

import com.google.gson.annotations.SerializedName;


/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginRequest {

    @SerializedName("grant_type")
    private String grantType;
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.grantType = "password";
        this.username = username;
        this.password = password;
    }

    public String getPlainBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(grantType);
        builder.append("&username=");
        builder.append(username);
        builder.append("&password=");
        builder.append(password);
        return builder.toString();
    }
}
