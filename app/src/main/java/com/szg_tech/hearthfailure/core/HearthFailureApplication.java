package com.szg_tech.hearthfailure.core;

import android.app.Application;

import io.realm.Realm;

public class HearthFailureApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
