package com.szg_tech.hearthfailure.utils.AppLock;

import android.app.Application;

/**
 * Created by Simple Design on 3/14/2018.
 */
public class ApplockManager {
    private static ApplockManager instance;
    private DefaultApplock currentAppLocker;

    public static ApplockManager getInstance() {
        if (instance == null) {
            instance = new ApplockManager();
        }
        return instance;
    }

    public void enableDefaultAppLockIfAvailable(Application currentApp) {
        if (currentAppLocker == null) {
            currentAppLocker = new DefaultApplock(currentApp);
        }

    }

    public void updateTouch(){
        currentAppLocker.updateTouch();
    }
}