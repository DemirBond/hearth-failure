package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class BoldEvaluationItem extends EvaluationItem {
    private boolean isBackgroundHighlighted;

    public BoldEvaluationItem(Context context, String id, String name, boolean isMandatory) {
        super(context, id, name, null, isMandatory);
    }

    public boolean isBackgroundHighlighted() {
        return isBackgroundHighlighted;
    }

    protected void setBackgroundHighlighted(boolean isBackgroundHighlighted) {
        this.isBackgroundHighlighted = isBackgroundHighlighted;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object object) {
    }
}
