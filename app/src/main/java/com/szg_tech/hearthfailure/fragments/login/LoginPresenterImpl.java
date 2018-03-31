package com.szg_tech.hearthfailure.fragments.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.activities.authentication.AuthenticationActivity;
import com.szg_tech.hearthfailure.core.AbstractPresenter;
import com.szg_tech.hearthfailure.core.views.modal.ProgressModalManager;
import com.szg_tech.hearthfailure.fragments.register.RegisterFragment;
import com.szg_tech.hearthfailure.rest.api.RestClientProvider;
import com.szg_tech.hearthfailure.rest.authentication.AuthenticationClient;
import com.szg_tech.hearthfailure.rest.requests.LoginRequest;
import com.szg_tech.hearthfailure.rest.responses.LoginResponse;
import com.szg_tech.hearthfailure.storage.PreferenceHelper;
import com.szg_tech.hearthfailure.storage.entities.Credentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class LoginPresenterImpl extends AbstractPresenter<LoginView> implements LoginPresenter {

    LoginPresenterImpl(LoginView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new LoginPresenterImpl.RecyclerViewAdapter(activity));
//            ((AuthenticationActivity)activity).onLoginSucceed();
//            tryLogin("demo", "demo1");
        }
        checkCredentials();
    }

    @Override
    public void onResume() {

        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.login);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }

        ((AuthenticationActivity)activity).showMenu(false);

    }

    private void checkCredentials() {
        Credentials credentials = PreferenceHelper.getCredentials(getActivity());
//        if(!credentials.isExpired()) {
//            RestClientProvider.init(credentials.getToken());
//            ((AuthenticationActivity)getActivity()).onLoginSucceed();
//        }

        if(!credentials.isEmpty()) {
            tryLogin(credentials.getEmail(), credentials.getPassword());
        }
    }

    private void tryLogin(String email, String password) {

        Activity activity = getActivity();

        final ProgressDialog progressDialog = ProgressModalManager.createAndShowLoginProgressDialog(activity);
        new AuthenticationClient().getAuthenticationService().login(new LoginRequest(email, password).getPlainBody())
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        progressDialog.dismiss();
                        if(response.isSuccessful()) {
                            if(response.body().isSucceed()) {
                                RestClientProvider.init(response.body().getAccessToken());

                                Credentials newCredentials = new Credentials(email, password, response.body().getAccessTokenWithType(),
                                        System.currentTimeMillis() + (response.body().getExpiresIn()*1000));

                                PreferenceHelper.putCredentials(activity, newCredentials);
                                ((AuthenticationActivity)activity).onLoginSucceed();

                            }
                        } else {
                            showSnackbarBottomButtonLoginError(activity);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                        //TODO There is a serious problem, handle with this
                        progressDialog.dismiss();
                        showSnackbarBottomButtonLoginError(activity);
                        t.printStackTrace();
                    }
                });
    }

    private void showSnackbarBottomButtonLoginError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_login_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<LoginPresenterImpl.RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public LoginPresenterImpl.RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.login_layout, parent, false);
            return new LoginPresenterImpl.RecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(LoginPresenterImpl.RecyclerViewAdapter.ViewHolder holder, int position) {
                holder.loginButton.setOnClickListener(new LoginOnClickLister(holder));
                holder.linkSignup.setOnClickListener(v -> {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, new RegisterFragment())
                            .addToBackStack(RegisterFragment.class.getSimpleName())
                            .commit();
                });
        }

        class LoginOnClickLister implements View.OnClickListener {

            final ViewHolder holder;
            public LoginOnClickLister(ViewHolder holder) {
                this.holder = holder;
            }

            @Override
            public void onClick(View v) {
                System.out.println("I am in LoginFragment on click");
                String email = holder.email.getText().toString();
                String password = holder.password.getText().toString();
                if(validate())
                {
                    tryLogin(email, password);
                }
            }

            private boolean validate() {
                boolean valid = true;

                String email = holder.email.getText().toString();
                String password = holder.password.getText().toString();

                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    holder.email.setError("enter a valid email address");
                    valid = false;
                } else {
                    holder.password.setError(null);
                }

                if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                    holder.password.setError("between 4 and 10 alphanumeric characters");
                    valid = false;
                } else {
                    holder.password.setError(null);
                }

                return valid;
            }
        }

        @Override
        public int getItemCount() {
            return 1;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            TextView email;
            TextView password;
            TextView loginButton;
            TextView linkSignup;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                email = (TextView) itemView.findViewById(R.id.input_email);
                password = (TextView) itemView.findViewById(R.id.input_password);
                linkSignup = (TextView) itemView.findViewById(R.id.link_signup);
                loginButton = (TextView) itemView.findViewById(R.id.btn_login);
            }
        }
    }
}
