package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;

public class SectionPlaceholderEvaluationItem extends EvaluationItem {
    private ArrayList<EvaluationItem> evaluationItemList;

    public SectionPlaceholderEvaluationItem(Context context, String id, String name, String hint, boolean isMandatory, ArrayList<EvaluationItem> evaluationItemList) {
        super(context, id, name, hint, isMandatory);
        this.evaluationItemList = evaluationItemList;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }
}
