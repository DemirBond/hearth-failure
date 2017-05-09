package com.szg_tech.hearthfailure.fragments.about;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.hearthfailure.core.MVPView;

interface AboutView extends MVPView {
    RecyclerView getRecyclerView();
}
