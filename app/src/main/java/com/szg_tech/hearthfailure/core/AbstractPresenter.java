package com.szg_tech.hearthfailure.core;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class AbstractPresenter<T extends MVPView> implements Presenter {

    private final T view;

    public AbstractPresenter(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    protected Activity getActivity() {
        return getView().getActivity();
    }

    protected FragmentManager getSupportFragmentManager() {
        FragmentManager fragmentManager = null;
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            fragmentManager = activity.getSupportFragmentManager();
        }
        return fragmentManager;
    }

    public void popBackStack() {
        popBackStack(1);
    }

    protected void popBackStack(int count) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            try {
                for (int i = 0; i < count; i++) {
                    fragmentManager.popBackStack();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO this is not optimal way to deal with this issue. Look for better implementation
    public int PAHpositionInBackStack() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            int c = fragmentManager.getBackStackEntryCount();
            for (int i = c-1; i >= 0; i--) {
                String fName = fragmentManager.getBackStackEntryAt(i).getName();
                //TODO This comparison should not be hard coded
                if(fName.equalsIgnoreCase("FragmentManagerImplHeart Specialist Management")) {
                    return (c - i) - 1;
                }
            }
        }
        return -1;
    }

    protected void runOnUiThread(Runnable action) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(action);
        }
    }
}
