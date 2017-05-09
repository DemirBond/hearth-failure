package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;

public class SectionCheckboxEvaluationItem extends EvaluationItem {
    private ArrayList<EvaluationItem> evaluationItemList;
    private boolean isChecked = false;
    private boolean shouldShowAlert;

    public SectionCheckboxEvaluationItem(Context context, String id, String name, boolean isMandatory, ArrayList<EvaluationItem> evaluationItemList) {
        super(context, id, name, null, isMandatory);
        this.evaluationItemList = evaluationItemList;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isShouldShowAlert() {
        return shouldShowAlert;
    }

    protected void setShouldShowAlert(boolean shouldShowAlert) {
        this.shouldShowAlert = shouldShowAlert;
    }

    public Boolean getValue() {
        return isChecked;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Boolean) {
            setChecked((Boolean) value);
        }
    }
}
