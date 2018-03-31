package com.szg_tech.hearthfailure.fragments.auth;

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
import com.szg_tech.hearthfailure.fragments.login.LoginPresenter;
import com.szg_tech.hearthfailure.fragments.login.LoginView;
import com.szg_tech.hearthfailure.fragments.register.RegisterFragment;
import com.szg_tech.hearthfailure.rest.api.RestClientProvider;
import com.szg_tech.hearthfailure.rest.authentication.AuthenticationClient;
import com.szg_tech.hearthfailure.rest.requests.AuthRequest;
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

public class AuthPresenterImpl extends AbstractPresenter<AuthView> implements AuthPresenter {

    AuthPresenterImpl(AuthView view) {
        super(view);
    }

    private String email;

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new AuthPresenterImpl.RecyclerViewAdapter(activity));
        }
    }

    @Override
    public void onResume() {

        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.auth);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }

        ((AuthenticationActivity)activity).showMenu(true);

    }

    private void tryAuth(String code) {

        final Activity activity = getActivity();

        final ProgressDialog progressDialog = ProgressModalManager.createAndShowLoginProgressDialog(activity);
        new AuthenticationClient().getAuthenticationService().activate(new AuthRequest(email, code).getPlainBody())
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        progressDialog.dismiss();
                        if(response.isSuccessful()) {
                            showSnackbarBottomButtonAuthError(activity);
                            getSupportFragmentManager().popBackStack();

                            ((AuthenticationActivity)activity).onLoginSucceed();

                        } else {
                            showSnackbarBottomButtonAuthError(activity);
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        progressDialog.dismiss();
                    }
                });
    }

    private void showSnackbarBottomButtonAuthError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_auth_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<AuthPresenterImpl.RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public AuthPresenterImpl.RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.auth_layout, parent, false);
            return new AuthPresenterImpl.RecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(AuthPresenterImpl.RecyclerViewAdapter.ViewHolder holder, int position) {
                holder.btnSubmit.setOnClickListener(new AuthOnClickLister(holder));
                /*holder.txtContactAdmin.setOnClickListener(v -> {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, new AuthFragment())
                            .addToBackStack(AuthFragment.class.getSimpleName())
                            .commit();
                });*/
        }

        class AuthOnClickLister implements View.OnClickListener {

            final ViewHolder holder;
            public AuthOnClickLister(ViewHolder holder) {
                this.holder = holder;
            }

            @Override
            public void onClick(View v) {
                System.out.println("I am in AuthFragment on click");
                String code = holder.txtCode.getText().toString();
                if(validate()) {
                    tryAuth(code);
                }
            }

            private boolean validate() {
                boolean valid = true;

                String code =  holder.txtCode.getText().toString();

                if (code.isEmpty()) {
                    holder.txtCode.setError("Input verification code.");
                    valid = false;
                } else {
                    holder.txtCode.setError(null);
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
            TextView txtCode;
            TextView btnSubmit;
            TextView txtContactAdmin;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                txtCode = (TextView) itemView.findViewById(R.id.input_code);
                txtContactAdmin = (TextView) itemView.findViewById(R.id.link_admin);
                btnSubmit = (TextView) itemView.findViewById(R.id.btn_submit);
            }
        }
    }
}
