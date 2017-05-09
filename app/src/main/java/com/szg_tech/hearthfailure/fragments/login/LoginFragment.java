package com.szg_tech.hearthfailure.fragments.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurableFragment;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class LoginFragment extends ConfigurableFragment implements LoginView {


    private RecyclerView recyclerView;
    private LoginPresenter presenter = createPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        presenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenterImpl(this);
    }
}
