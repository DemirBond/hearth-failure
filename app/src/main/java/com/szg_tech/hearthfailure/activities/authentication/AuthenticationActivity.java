package com.szg_tech.hearthfailure.activities.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.BaseAppCompatActivity;
import com.szg_tech.hearthfailure.activities.main.MainActivity;
import com.szg_tech.hearthfailure.fragments.login.LoginFragment;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class AuthenticationActivity extends AppCompatActivity implements AuthenticationActivityView {
    private AuthenticationActivityPresenter presenter = createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new LoginFragment())
                .addToBackStack(LoginFragment.class.getSimpleName())
                .commit();
        presenter.onCreate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public AuthenticationActivityPresenter createPresenter() {
        return new AuthenticationActivityPresenterImpl(this);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public void onLoginSucceed() {
        startActivity(MainActivity.class);
    }

    @Override
    public void showMenu(boolean isVisible) {
        isMenuVisible = isVisible;
        invalidateOptionsMenu();
    }

    boolean isMenuVisible = false;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        if (isMenuVisible) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.authentication_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_cancel) {
            getSupportFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }
}
