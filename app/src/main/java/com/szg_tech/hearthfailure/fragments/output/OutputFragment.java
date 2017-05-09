package com.szg_tech.hearthfailure.fragments.output;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.ConfigurableFragment;

public class OutputFragment extends ConfigurableFragment implements OutputView {
    OutputPresenter presenter = createPresenter();
    View returnToEvaluationButton;
    View completeEvaluationButton;
    RecyclerView recyclerView;

    public OutputPresenterImpl createPresenter() {
        return new OutputPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.output_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        returnToEvaluationButton = view.findViewById(R.id.return_to_evaluation);
        returnToEvaluationButton.setOnClickListener(v -> presenter.onReturnToEvaluationButtonClick());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        completeEvaluationButton = view.findViewById(R.id.complete_evaluation);
        completeEvaluationButton.setOnClickListener(v -> presenter.onCompleteEvaluationButtonClick());
        setHasOptionsMenu(true);
        presenter.onCreate();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        presenter.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
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

}
