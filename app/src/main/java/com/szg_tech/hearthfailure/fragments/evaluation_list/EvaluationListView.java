package com.szg_tech.hearthfailure.fragments.evaluation_list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.szg_tech.hearthfailure.core.MVPView;
import com.szg_tech.hearthfailure.core.views.ButtonWithChevron;

interface EvaluationListView extends MVPView {
    RecyclerView getRecyclerView();

    Bundle getArguments();

    ButtonWithChevron getBottomButton();
}
