package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;

public class RadioButtonGroupEvaluationItem extends EvaluationItem {
    private String groupName;
    private boolean isChecked;
    private boolean isBackgroundHighlighted;
    private ArrayList<EvaluationItem> evaluationItemList;

    public RadioButtonGroupEvaluationItem(Context context, String id, String name, String groupName, boolean isMandatory, boolean isChecked) {
        this(context, id, name, groupName, isMandatory, isChecked, null);
    }

    protected RadioButtonGroupEvaluationItem(Context context, String id, String name, String groupName, boolean isMandatory, boolean isChecked, ArrayList<EvaluationItem> evaluationItemList) {
        super(context, id, name, null, isMandatory);
        this.groupName = groupName;
        this.isChecked = isChecked;
        this.evaluationItemList = evaluationItemList;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    @Override
    public Object getValue() {
        return isChecked;
    }

    @Override
    public void setValue(Object value) {
        isChecked = (Boolean) value;
    }

    public boolean isBackgroundHighlighted() {
        return isBackgroundHighlighted;
    }

    protected void setBackgroundHighlighted(boolean backgroundHighlighted) {
        isBackgroundHighlighted = backgroundHighlighted;
    }
}
