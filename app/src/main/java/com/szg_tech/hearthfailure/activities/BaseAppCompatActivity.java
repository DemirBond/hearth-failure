package com.szg_tech.hearthfailure.activities;

import android.support.v7.app.AppCompatActivity;

import com.szg_tech.hearthfailure.core.HearthFailureApplication;

/**
 * Created by Simple Design on 3/14/2018.
 */

public class BaseAppCompatActivity extends AppCompatActivity {
    public HearthFailureApplication getApp() {
        return (HearthFailureApplication)getApplication();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        getApp().touch();
    }
}
