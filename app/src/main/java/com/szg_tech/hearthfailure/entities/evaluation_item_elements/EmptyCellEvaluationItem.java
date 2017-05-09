package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class EmptyCellEvaluationItem extends EvaluationItem {
    public EmptyCellEvaluationItem() {
        super(null, null, null, null, false);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }
}
