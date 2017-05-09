package com.szg_tech.hearthfailure.fragments.evaluation_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurableFragment;
import com.szg_tech.hearthfailure.core.views.ButtonWithChevron;

public class EvaluationListFragment extends ConfigurableFragment implements EvaluationListView {
    EvaluationListPresenter presenter = createPresenter();
    RecyclerView recyclerView;
    ButtonWithChevron bottomButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.evaluation_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        bottomButton = (ButtonWithChevron) view.findViewById(R.id.bottom_button);
        bottomButton.setOnClickListener(v -> presenter.onBottomButtonClick());
        presenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public EvaluationListPresenter createPresenter() {
        return new EvaluationListPresenterImpl(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public ButtonWithChevron getBottomButton() {
        return bottomButton;
    }
}
