package com.szg_tech.hearthfailure.core.views.cell;

import com.szg_tech.hearthfailure.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionDependsOnManager {
    private Map<SectionEvaluationItem, List<SectionEvaluationItem>> dependsOnHashMap = new HashMap<>();

    private void onSectionElementStateChange(SectionEvaluationItem sectionEvaluationItem) {
//      if(sectionElementState== SectionEvaluationItem.SectionElementState.FILLED){
        if (sectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED) {
            List<SectionEvaluationItem> innerDependentList = dependsOnHashMap.get(sectionEvaluationItem);
            if (innerDependentList != null) {
                for (SectionEvaluationItem innerSectionEvaluationItem : innerDependentList) {
                    if (innerSectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                        innerSectionEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                    }
                }
            }
        }

    }

    public void addToMap(SectionEvaluationItem main, SectionEvaluationItem dependant) {
        List<SectionEvaluationItem> dependantSectionEvaluationItemList = dependsOnHashMap.get(main);
        if (dependantSectionEvaluationItemList == null) {
            dependantSectionEvaluationItemList = new ArrayList<>();
            dependsOnHashMap.put(main, dependantSectionEvaluationItemList);
            main.setOnSectionElementStateChangeListener(this::onSectionElementStateChange);
        }
        dependantSectionEvaluationItemList.add(dependant);
    }
}
