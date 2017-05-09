package com.szg_tech.hearthfailure.core.views.cell;

import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.szg_tech.hearthfailure.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RadioViewManager {
    private Map<RadioButtonCell, RadioButtonGroupEvaluationItem> radioButtonMap = new HashMap<>();

    private void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Set<RadioButtonCell> radioButtonCells = radioButtonMap.keySet();
            RadioButton checkedRadioButton = (RadioButton) buttonView;
            for (RadioButtonCell radioButtonCell : radioButtonCells) {
                RadioButton radioButton = radioButtonCell.getRadioButton();
                if (!radioButton.equals(checkedRadioButton)) {
                    radioButton.setChecked(false);
                    radioButtonCell.setChecked(false);
                    radioButtonMap.get(radioButtonCell).setChecked(false);
                } else {
                    radioButton.setChecked(true);
                    radioButtonMap.get(radioButtonCell).setChecked(true);
                }
            }
        }
    }

    public void addToMap(RadioButtonCell radioButtonCell, RadioButtonGroupEvaluationItem radioButtonGroupEvaluationItem) {
        radioButtonMap.put(radioButtonCell, radioButtonGroupEvaluationItem);
        radioButtonCell.getRadioButton().setOnCheckedChangeListener(RadioViewManager.this::onCheckedChanged);
    }
}
