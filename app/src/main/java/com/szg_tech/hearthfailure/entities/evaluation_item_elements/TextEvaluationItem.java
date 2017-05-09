package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class TextEvaluationItem extends EvaluationItem {
    public TextEvaluationItem(Context context, String id, String name, boolean isMandatory) {
        super(context, id, name, null, isMandatory);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object object) {
    }
}
