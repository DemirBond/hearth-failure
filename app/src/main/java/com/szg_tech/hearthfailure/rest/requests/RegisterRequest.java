package com.szg_tech.hearthfailure.rest.requests;

/**
 * Created by ahmetkucuk on 4/2/17.
 */

public class RegisterRequest {

    private String name;
    private String username;
    private String password;
    private String confirmPassword;


    public RegisterRequest(String name, String username, String password, String confirmPassword) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getPlainBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("name=");
        builder.append(name);
        builder.append("&username=");
        builder.append(username);
        builder.append("&password=");
        builder.append(password);
        builder.append("&ConfirmPassword=");
        builder.append(confirmPassword);
        return builder.toString();
    }

}
