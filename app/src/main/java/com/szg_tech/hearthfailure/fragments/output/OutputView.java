package com.szg_tech.hearthfailure.fragments.output;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.hearthfailure.core.MVPView;

interface OutputView extends MVPView {
    RecyclerView getRecyclerView();

}
