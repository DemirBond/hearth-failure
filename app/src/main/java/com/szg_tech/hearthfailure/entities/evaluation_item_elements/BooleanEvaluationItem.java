package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class BooleanEvaluationItem extends EvaluationItem {
    private boolean isChecked = false;
    private boolean isBackgroundHighlighted;

    public BooleanEvaluationItem(Context context, String id, String name, boolean isMandatory) {
        super(context, id, name, null, isMandatory);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public Boolean getValue() {
        return isChecked;
    }

    @Override
    public void setValue(Object object) {
        if (object instanceof Boolean)
            isChecked = (Boolean) object;
    }

    public boolean isBackgroundHighlighted() {
        return isBackgroundHighlighted;
    }

    protected void setBackgroundHighlighted(boolean backgroundHighlighted) {
        isBackgroundHighlighted = backgroundHighlighted;
    }
}
