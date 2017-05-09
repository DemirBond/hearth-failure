package com.szg_tech.hearthfailure.fragments.home;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.hearthfailure.core.MVPView;

interface HomeView extends MVPView {
    RecyclerView getRecyclerView();
}
