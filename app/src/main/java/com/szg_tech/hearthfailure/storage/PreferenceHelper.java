package com.szg_tech.hearthfailure.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.szg_tech.hearthfailure.storage.entities.Credentials;

public class PreferenceHelper {
    private static final String TEXT_DELTA = "text_delta";

    public static void putTextDelta(Context context, float textDelta) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().putFloat(TEXT_DELTA, textDelta).apply();
    }

    public static float getTextDelta(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getFloat(TEXT_DELTA, 0);
    }

    public static void putCredentials(Context context, Credentials token) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().putString(Credentials.TOKEN, token.getToken()).apply();
        sharedPreferences.edit().putString(Credentials.EMAIL, token.getEmail()).apply();
        sharedPreferences.edit().putString(Credentials.PASSWORD, token.getPassword()).apply();
        sharedPreferences.edit().putLong(Credentials.EXPIRE_DATE, token.getExpireDate()).apply();
    }

    public static Credentials getCredentials(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = sharedPreferences.getString(Credentials.TOKEN, "");
        String email = sharedPreferences.getString(Credentials.EMAIL, "");
        String password = sharedPreferences.getString(Credentials.PASSWORD, "");
        long expireDate = sharedPreferences.getLong(Credentials.EXPIRE_DATE, 0);
        return new Credentials(email, password, token, expireDate);
    }

    public static void removeCredentials(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().remove(Credentials.TOKEN)
                .remove(Credentials.EMAIL)
                .remove(Credentials.PASSWORD)
                .remove(Credentials.EXPIRE_DATE).apply();
    }
}
