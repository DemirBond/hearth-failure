package com.szg_tech.hearthfailure.fragments.register;

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
import com.szg_tech.hearthfailure.fragments.auth.AuthFragment;
import com.szg_tech.hearthfailure.rest.authentication.AuthenticationClient;
import com.szg_tech.hearthfailure.rest.authentication.AuthenticationClientProvider;
import com.szg_tech.hearthfailure.rest.requests.RegisterRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class RegisterPresenterImpl extends AbstractPresenter<RegisterView> implements RegisterPresenter {


    RegisterPresenterImpl(RegisterView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RegisterPresenterImpl.RecyclerViewAdapter(activity));
        }
    }

    @Override
    public void onResume() {

        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.register);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }

        ((AuthenticationActivity)activity).showMenu(true);

    }

    private void tryRegister(String name, String email, String password, String confirmPassword) {

        Activity activity = getActivity();
        AuthenticationClient authenticationClient = AuthenticationClientProvider.get();

        final ProgressDialog progressDialog = ProgressModalManager.createAndShowRegisterProgressDialog(activity);
        authenticationClient.getAuthenticationService().register(new RegisterRequest(name, email, password, confirmPassword).getPlainBody())
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        progressDialog.dismiss();
                        if(response.isSuccessful()) {
                            showSnackbarBottomButtonRegisterSucceed(activity);
//                            getSupportFragmentManager().popBackStack();

                            getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                    .replace(R.id.container, new AuthFragment())
                                    .addToBackStack(AuthFragment.class.getSimpleName())
                                    .commit();


                        } else {
                            showSnackbarBottomButtonRegisterError(activity);
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        //TODO There is a serious problem, handle with this
                        progressDialog.dismiss();
                        showSnackbarBottomButtonRegisterError(activity);
                        t.printStackTrace();
                    }
                });
    }

    private void showSnackbarBottomButtonRegisterError(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_register_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonRegisterSucceed(Activity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_register_succeed, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.green_text));
            snackbar.show();
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.register_layout, parent, false);
            return new RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder holder, int position) {
            holder.registerButton.setOnClickListener(new OnRegisterClickListener(holder));

            holder.linkLogin.setOnClickListener(v -> {
                getSupportFragmentManager().popBackStack();
            });
        }

        class OnRegisterClickListener implements View.OnClickListener {

            private ViewHolder holder;

            OnRegisterClickListener(ViewHolder holder) {
                this.holder = holder;
            }

            @Override
            public void onClick(View v) {

                if(validate()) {

                    String name = holder.name.getText().toString();
                    String email = holder.email.getText().toString();
                    String password = holder.password.getText().toString();
                    String confirmPassword = holder.confirmPassword.getText().toString();
                    tryRegister(name, email, password, confirmPassword);
                }
            }

            public boolean validate() {
                boolean valid = true;

                String name = holder.name.getText().toString();
                String email = holder.email.getText().toString();
                String password = holder.password.getText().toString();
                String reEnterPassword = holder.confirmPassword.getText().toString();

                if (name.isEmpty() || name.length() < 3) {
                    holder.name.setError("at least 3 characters");
                    valid = false;
                } else {
                    holder.name.setError(null);
                }

                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    holder.email.setError("enter a valid email address");
                    valid = false;
                } else {
                    holder.email.setError(null);
                }

                if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                    holder.password.setError("between 4 and 10 alphanumeric characters");
                    valid = false;
                } else {
                    holder.password.setError(null);
                }

                if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
                    holder.confirmPassword.setError("Password Do not match");
                    valid = false;
                } else {
                    holder.confirmPassword.setError(null);
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
            TextView name;
            TextView email;
            TextView password;
            TextView confirmPassword;
            TextView registerButton;
            TextView linkLogin;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                name = (TextView) itemView.findViewById(R.id.input_name);
                email = (TextView) itemView.findViewById(R.id.input_email);
                password = (TextView) itemView.findViewById(R.id.input_password);
                confirmPassword = (TextView) itemView.findViewById(R.id.input_re_enter_password);
                linkLogin = (TextView) itemView.findViewById(R.id.link_login);
                registerButton = (TextView) itemView.findViewById(R.id.btn_register);
            }
        }
    }

}
