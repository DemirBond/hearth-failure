package com.szg_tech.hearthfailure.activities.authentication;

import android.app.Activity;

import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.core.NetworkConnectivityControl;
import com.szg_tech.hearthfailure.core.views.modal.AlertModalManager;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class AuthenticationActivityPresenterImpl extends AbstractPresenter<AuthenticationActivityView> implements AuthenticationActivityPresenter, NetworkConnectivityControl.OnNetworkNotUsableListener {


    AuthenticationActivityPresenterImpl(AuthenticationActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        checkInternet();
    }

    private void checkInternet() {
        new NetworkConnectivityControl(getActivity(), this).execute();
    }


    @Override
    public void onNetworkConnectionFailed() {
        Activity activity = getActivity();
        if(activity != null) {
            AlertModalManager.createAndShowNoInternetConnectionAlertDialog(activity, (v) -> activity.onBackPressed());
        }
    }
}
