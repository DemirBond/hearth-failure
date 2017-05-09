package com.szg_tech.hearthfailure.activities.main;

import com.szg_tech.hearthfailure.core.MVPView;

interface MainActivityView extends MVPView {
    OnAuthorizationChangedListener getOnAuthorizationChangedListener();
}
