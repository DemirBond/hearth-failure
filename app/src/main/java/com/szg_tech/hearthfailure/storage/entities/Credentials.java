package com.szg_tech.hearthfailure.storage.entities;

/**
 * Created by ahmetkucuk on 3/26/17.
 */

public class Credentials {

    public static final String TOKEN = "token";
    public static final String EXPIRE_DATE = "expireDate";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    private String token;
    private long expireDate;
    private String email;
    private String password;


    public Credentials(String email, String password, String token, long expireDate) {
        this.email = email;
        this.password = password;
        this.token = token;
        this.expireDate = expireDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isExpired() {
        if(System.currentTimeMillis() >= expireDate)
            return true;
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmpty(){

        if(email == null || email.isEmpty()) return true;
        if(password == null || password.isEmpty()) return true;

        return false;
    }
}
