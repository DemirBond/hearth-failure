package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;

public class HeartPartnerEvaluationItem extends EvaluationItem {
    private String departmentName;
    private String description;
    private String hours;
    private ArrayList<EvaluationItem> evaluationItems;

    public HeartPartnerEvaluationItem(Context context, String id, String departmentName, String description, String hours,
                                      ArrayList<EvaluationItem> evaluationItems) {
        super(context, id, null, null, false);
        this.departmentName = departmentName;
        this.description = description;
        this.hours = hours;
        this.evaluationItems = evaluationItems;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }

    public String getHours() {
        return hours;
    }

    public ArrayList<EvaluationItem> getEvaluationItems() {
        return evaluationItems;
    }
}
