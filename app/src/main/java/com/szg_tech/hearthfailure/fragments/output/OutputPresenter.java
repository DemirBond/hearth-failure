package com.szg_tech.hearthfailure.fragments.output;

import android.view.Menu;
import android.view.MenuItem;

import com.szg_tech.hearthfailure.core.Presenter;

interface OutputPresenter extends Presenter {
    void onCreate();

    void onReturnToEvaluationButtonClick();

    void onCompleteEvaluationButtonClick();

    void onResume();

    boolean onOptionsItemSelected(MenuItem item);

    void onPrepareOptionsMenu(Menu menu);



}
