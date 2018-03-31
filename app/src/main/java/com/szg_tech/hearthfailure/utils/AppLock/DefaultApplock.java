package com.szg_tech.hearthfailure.utils.AppLock;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.szg_tech.hearthfailure.activities.authentication.SplashActivity;

import java.util.Date;

/**
 * Created by Simple Design on 3/14/2018.
 */

public class DefaultApplock implements Application.ActivityLifecycleCallbacks {

    final String TAG = DefaultApplock.class.getSimpleName();

    private Application mCurrentApp;

    private long WAIT_TIME = 5*60*1000; //5Min
//    private long WAIT_TIME = 10*1000; //For test 10 seconds
    private Waiter waiter;
    private Date mLostFocusDate;

    public DefaultApplock(Application app) {
        super();
        mCurrentApp = app;

        //Registering Activity lifecycle callbacks
        mCurrentApp.unregisterActivityLifecycleCallbacks(this);
        mCurrentApp.registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        // for UserInactivity
        if(waiter!=null) {
            waiter.stopThread();
        }
        waiter=new Waiter(activity,WAIT_TIME);
        waiter.start();

        // for Screen lock
        if (shouldShowUnlockScreen()) {
            Log.d(TAG, "time over");
            //

            Intent intent = new Intent(activity.getApplicationContext(), SplashActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d(TAG, "changing mLostFocus to null");
            mLostFocusDate = null;
            activity.getApplicationContext().startActivity(intent);

        }
    }

    private boolean shouldShowUnlockScreen() {
        boolean isvalid = false;
        if (mLostFocusDate == null) {
            isvalid = false;
        } else {
            Log.d(TAG, "Timeout -&gt;"+timeSinceLocked());
            if (timeSinceLocked() >= (WAIT_TIME/1000)) {
                isvalid = true;
            } else {
                mLostFocusDate = null;
            }
        }
        return isvalid;
    }

    private int timeSinceLocked() {
        return Math.abs((int) ((new Date().getTime() - mLostFocusDate.getTime()) / 1000));
    }


    @Override
    public void onActivityPaused(Activity activity) {
        if(waiter!=null) {
            waiter.stopThread();
        }
        mLostFocusDate = new Date();
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public void updateTouch() {
        if(waiter!=null) {
            waiter.touch();
        }
        mLostFocusDate = new Date();
    }
}