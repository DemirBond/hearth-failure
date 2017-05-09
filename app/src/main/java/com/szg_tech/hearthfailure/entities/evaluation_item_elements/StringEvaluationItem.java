package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class StringEvaluationItem extends EvaluationItem {
    private String text;
    private String validationRegexp;
    private boolean isEditable = true;

    public StringEvaluationItem(Context context, String id, String name, String hint, boolean isMandatory, String validationRegexp) {
        super(context, id, name, hint, isMandatory);
        this.validationRegexp = validationRegexp;
        if (!isMandatory) {
            setValid(true);
        } else {
            setValid(false);
        }
    }

    public String getText() {
        return text;
    }

    public boolean isEditable() {
        return isEditable;
    }

    protected void setEditable(boolean editable) {
        isEditable = editable;
    }

    public void setText(String text) {
        this.text = text;
        if (text != null) {
            setValid(true);
        } else {
            if (!isMandatory()) {
                setValid(true);
            } else {
                setValid(false);
            }
        }
    }

    public String getValidationRegexp() {
        return validationRegexp;
    }

    @Override
    public Object getValue() {
        return text;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof String) {
            setText((String) value);
        }
    }
}
