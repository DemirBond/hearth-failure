package com.szg_tech.hearthfailure.activities.authentication;

import com.szg_tech.hearthfailure.core.MVPView;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public interface AuthenticationActivityView extends MVPView {

    void onLoginSucceed();

    void showMenu(boolean isVisible);
}
