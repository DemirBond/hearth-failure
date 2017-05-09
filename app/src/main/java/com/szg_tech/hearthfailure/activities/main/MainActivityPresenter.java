package com.szg_tech.hearthfailure.activities.main;

import android.view.MenuItem;

import com.szg_tech.hearthfailure.core.Presenter;

interface MainActivityPresenter extends Presenter {
    void onCreate();

    boolean onOptionsItemSelected(MenuItem item);
}
