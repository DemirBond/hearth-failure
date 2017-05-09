package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;
import java.util.List;

public class NumericalEvaluationItem extends EvaluationItem {
    private double from;
    private double to;
    private boolean isWhole;
    private Double number = null;
    private transient List<OnValueChangeListener> onValueChangeListenerList = new ArrayList<>();

    public NumericalEvaluationItem(Context context, String id, String name, String hint, double from, double to, boolean isMandatory) {
        this(context, id, name, hint, from, to, isMandatory, false);
    }

    public NumericalEvaluationItem(Context context, String id, String name, String hint, double from, double to, boolean isMandatory, boolean isWhole) {
        super(context, id, name, hint, isMandatory);
        this.from = from;
        this.to = to;
        this.isWhole = isWhole;
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
        for (OnValueChangeListener onValueChangeListener : onValueChangeListenerList) {
            onValueChangeListener.onValueChange(number);
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
        } else if (value instanceof Float) {
            setNumber(((Float) value).doubleValue());
        } else if (value instanceof Integer) {
            setNumber(((Integer) value).doubleValue());
        } else {
            number = null;
        }
    }

    public void addOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        onValueChangeListenerList.add(onValueChangeListener);
    }

    public interface OnValueChangeListener {
        void onValueChange(Double value);
    }
}
