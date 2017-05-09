package com.szg_tech.hearthfailure.rest.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetkucuk on 4/2/17.
 */
public class RegisterResponse {

    @SerializedName("Message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
