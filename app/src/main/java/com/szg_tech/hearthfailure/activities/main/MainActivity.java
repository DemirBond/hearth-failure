package com.szg_tech.hearthfailure.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.BaseAppCompatActivity;
import com.szg_tech.hearthfailure.fragments.home.HomeFragment;
import com.szg_tech.hearthfailure.utils.AppLock.ApplockManager;

public class MainActivity extends BaseAppCompatActivity implements MainActivityView {
    private MainActivityPresenter presenter = createPresenter();

    private OnAuthorizationChangedListener onAuthorizationChangedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new HomeFragment())
                .addToBackStack(HomeFragment.class.getSimpleName())
                .commit();
        presenter.onCreate();

        ApplockManager.getInstance().enableDefaultAppLockIfAvailable(getApplication());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenterImpl(this);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }

    @Override
    public OnAuthorizationChangedListener getOnAuthorizationChangedListener() {
        return onAuthorizationChangedListener;
    }

    public void setOnAuthorizationChangedListener(OnAuthorizationChangedListener onAuthorizationChangedListener) {
        this.onAuthorizationChangedListener = onAuthorizationChangedListener;
    }
}
