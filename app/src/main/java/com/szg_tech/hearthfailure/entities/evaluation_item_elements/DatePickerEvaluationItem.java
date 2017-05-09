package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class DatePickerEvaluationItem extends EvaluationItem {
    private Long date;

    public DatePickerEvaluationItem(Context context, String id, String name, boolean isMandatory) {
        super(context, id, name, null, isMandatory);
    }

    @Override
    public Long getValue() {
        return date;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Long) {
            date = (Long) value;
        }
    }

    public Long getDate() {
        return date;
    }
}
