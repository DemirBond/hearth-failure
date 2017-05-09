package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

public class ICOCellEvaluationItem extends EvaluationItem {
    private String blueButtonText;
    private String greenButtonText;

    public ICOCellEvaluationItem(Context context, String id, String name, String hint,
                                 String blueButtonText, String greenButtonText) {
        super(context, id, name, hint, false);
        this.blueButtonText = blueButtonText;
        this.greenButtonText = greenButtonText;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    public String getBlueButtonText() {
        return blueButtonText;
    }

    public String getGreenButtonText() {
        return greenButtonText;
    }
}
