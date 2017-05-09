package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class NumericalDependantEvaluationItem extends EvaluationItem {
    private double from;
    private double to;
    private boolean isWhole;
    private String dependsOn;
    private int enableFrom;
    private int enableTo;
    private Double number = null;

    public NumericalDependantEvaluationItem(Context context, String id, String name, String hint, double from,
                                            double to, boolean isMandatory, boolean isWhole, String dependsOn,
                                            int enableFrom, int enableTo) {
        super(context, id, name, hint, isMandatory);
        this.from = from;
        this.to = to;
        this.isWhole = isWhole;
        this.dependsOn = dependsOn;
        this.enableFrom = enableFrom;
        this.enableTo = enableTo;
        if (!isMandatory) {
            setValid(true);
        } else {
            setValid(false);
        }
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public boolean isWhole() {
        return isWhole;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public int getEnableFrom() {
        return enableFrom;
    }

    public int getEnableTo() {
        return enableTo;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
        if (number != null) {
            setValid(true);
        } else {
            if (!isMandatory()) {
                setValid(true);
            } else {
                setValid(false);
            }
        }
    }

    @Override
    public Object getValue() {
        return number;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Double) {
            setNumber((Double) value);
        }
    }
}
