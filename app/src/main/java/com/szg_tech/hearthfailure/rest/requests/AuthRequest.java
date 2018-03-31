package com.szg_tech.hearthfailure.rest.requests;

/**
 * Created by ahmetkucuk on 4/2/17.
 */

public class AuthRequest {
    private String email;
    private String registrationCode;

    public AuthRequest(String email, String registrationCode) {
        this.email = email;
        this.registrationCode = registrationCode;
    }

    public String getPlainBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("username=");
        builder.append(email);
        builder.append("&RegistrationCode=");
        builder.append(registrationCode);
        return builder.toString();
    }

}
