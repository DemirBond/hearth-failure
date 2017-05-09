package com.szg_tech.hearthfailure.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.authentication.AuthenticationActivity;
import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.core.ConfigurableFragment;
import com.szg_tech.hearthfailure.core.ConfigurationParams;
import com.szg_tech.hearthfailure.entities.evaluation_items.About;
import com.szg_tech.hearthfailure.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.hearthfailure.storage.PreferenceHelper;

class MainActivityPresenterImpl extends AbstractPresenter<MainActivityView> implements MainActivityPresenter {
    MainActivityPresenterImpl(MainActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConfigurableFragment fragment = null;
        String backStackName = null;
        Activity activity = getActivity();
        switch (item.getItemId()) {
            case R.id.about:
                fragment = new EvaluationListFragment();
                Bundle bundle = new Bundle();
                if (activity != null) {
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION, new About(activity));
                    showActionBar(activity, true);
                }
                fragment.setArguments(bundle);
                backStackName = EvaluationListFragment.class.getSimpleName();
                break;
            case R.id.sign:
                item.setTitle(getActivity().getResources().getString(R.string.sign_out));

                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                PreferenceHelper.removeCredentials(getActivity());
                Intent intent = new Intent(getActivity(), AuthenticationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
                getActivity().finish();

//                boolean isAuthorized = item.getTitle().toString().equals(getActivity().getResources().getString(R.string.sign_in_up));
//                if (isAuthorized) {
//                    item.setTitle(getActivity().getResources().getString(R.string.sign_out));
//                } else {
//                    item.setTitle(getActivity().getResources().getString(R.string.sign_in_up));
//                }
//                OnAuthorizationChangedListener onAuthorizationChangedListener = getView().getOnAuthorizationChangedListener();
//                if (onAuthorizationChangedListener != null) {
//                    onAuthorizationChangedListener.onAuthorizationChanged(isAuthorized);
//                }
                return true;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && fragment != null) {
            int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
            if (backStackEntryCount < 1 || !fragment.getClass().getSimpleName().equals(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName())) {
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(backStackName).commit();
                return true;
            }
        }
        return false;
    }

    private void showActionBar(Activity activity, boolean isShow) {
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(isShow);
            }
        }
    }
}
