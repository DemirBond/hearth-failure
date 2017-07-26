package com.szg_tech.hearthfailure.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ahmetkucuk on 4/14/17.
 */

public class NetworkConnectivityControl extends AsyncTask<Void, Void, Boolean>{
    private Context context;
    private OnNetworkNotUsableListener listener;

    public NetworkConnectivityControl(Context context, OnNetworkNotUsableListener listener) {
        this.context = context;
        this.listener = listener;
    }


    @Override
    protected Boolean doInBackground(Void... params) {
        if(isConnectingToInternet()) return true;
        return false;
    }

    @Override
    protected void onPostExecute(Boolean isConnected) {
        super.onPostExecute(isConnected);
//        if(!isConnected) {
//            listener.onNetworkConnectionFailed();
//        }
    }

    private boolean isConnectingToInternet() {
        if (networkConnectivity()) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL(
                        "http://www.google.com").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(3000);
                urlc.setReadTimeout(4000);
                urlc.connect();
                // networkcode2 = urlc.getResponseCode();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                return (false);
            }
        } else
            return false;

    }

    private boolean networkConnectivity() {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public interface OnNetworkNotUsableListener {
        void onNetworkConnectionFailed();
    }

}
