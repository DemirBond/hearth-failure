package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;

public class TabEvaluationItem extends EvaluationItem {
    private ArrayList<SectionEvaluationItem> tabSectionList;

    public TabEvaluationItem(Context context, String id, String name, ArrayList<SectionEvaluationItem> tabSectionList) {
        super(context, id, name, null, false);
        this.tabSectionList = tabSectionList;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    public ArrayList<SectionEvaluationItem> getTabSectionList() {
        return tabSectionList;
    }
}
