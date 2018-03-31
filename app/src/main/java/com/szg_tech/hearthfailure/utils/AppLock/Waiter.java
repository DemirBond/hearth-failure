package com.szg_tech.hearthfailure.utils.AppLock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.szg_tech.hearthfailure.activities.authentication.AuthenticationActivity;
import com.szg_tech.hearthfailure.storage.PreferenceHelper;

/**
 * Created by Simple Design on 3/14/2018.
 */

public class Waiter extends Thread
{
    private static final String TAG=Waiter.class.getName();
    private long lastUsed;
    private long period;
    private boolean stop = false;
    private Context mContext;

    public Waiter(Context context,long period) {
        this.period=period;
        stop=false;
        mContext = context;
    }

    public void run() {
        long idle=0;
        this.touch();
        Log.e("Value of stop",String.valueOf(stop));
        do
        {
            idle=System.currentTimeMillis()-lastUsed;
            Log.e(TAG, "Application is idle for "+idle +" ms");
            try
            {
                Thread.sleep(2000); //check every 5 seconds
            }
            catch (InterruptedException e)
            {
                Log.d(TAG, "Waiter interrupted!");
            }
            if(idle >= period)
            {
                idle=0;
                //do something here - e.g. call popup or so
                Log.e("Session Expired", "Log Out here");

                PreferenceHelper.removeCredentials(mContext);
                Intent intent = new Intent(mContext, AuthenticationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                if (mContext instanceof Activity) {
                    ((Activity)mContext).finish();
                }

                // Perform Your desired Function like Logout or expire the session for the app.
                stopThread();
            }
        }
        while(!stop);
        Log.d(TAG, "Finishing Waiter thread");
    }

    public synchronized void touch() {
        lastUsed=System.currentTimeMillis();
    }

    public synchronized void forceInterrupt() {
        this.interrupt();
    }

    public synchronized void setPeriod(long period)
    {
        this.period=period;
    }

    public synchronized void stopThread() {
        stop = true;
    }

    public synchronized void startThread() {
        stop = false;
    }

    public synchronized void closeThread() {
        // Perform Your desired Function like Logout or expire the session for the app.
        stopThread();
    }



}