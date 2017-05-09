package com.szg_tech.hearthfailure.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.hearthfailure.entities.EvaluationItem;

import java.util.ArrayList;

public class SectionEvaluationItem extends EvaluationItem {
    protected SectionElementState sectionElementState;
    protected ArrayList<EvaluationItem> evaluationItemList;
    protected String dependsOn;
    private boolean shouldShowAlert;
    private transient OnSectionElementStateChangeListener onSectionElementStateChangeListener;
    private boolean hasStateIcon = true;
    private boolean isBottomButtonReferenceSkipped = false;


//    private Map<Class<EvaluationItem>, Set<String>> evaluationItemByKeys

    public SectionEvaluationItem(Context context, String id, String name, boolean isMandatory) {
        this(context, id, name, isMandatory, null, SectionElementState.LOCKED);
    }

    public SectionEvaluationItem(Context context, String id, String name, boolean isMandatory, ArrayList<EvaluationItem> evaluationItemList) {
        this(context, id, name, isMandatory, evaluationItemList, SectionElementState.LOCKED);
    }

    public SectionEvaluationItem(Context context, String id, String name, boolean isMandatory, ArrayList<EvaluationItem> evaluationItemList, SectionElementState sectionElementState) {
        super(context, id, name, null, isMandatory);
        this.evaluationItemList = evaluationItemList;
        this.sectionElementState = sectionElementState;
    }

    public SectionEvaluationItem(Context context, String id, String name, boolean isMandatory, ArrayList<EvaluationItem> evaluationItemList, SectionElementState sectionElementState, String dependsOn) {
        super(context, id, name, null, isMandatory);
        this.evaluationItemList = evaluationItemList;
        this.sectionElementState = sectionElementState;
        this.dependsOn = dependsOn;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    public SectionElementState getSectionElementState() {
        return sectionElementState;
    }

    public void setSectionElementState(SectionElementState sectionElementState) {
        this.sectionElementState = sectionElementState;
        if (onSectionElementStateChangeListener != null) {
            onSectionElementStateChangeListener.onSectionElementStateChange(this);
        }
    }

    public void setOnSectionElementStateChangeListener(OnSectionElementStateChangeListener onSectionElementStateChangeListener) {
        this.onSectionElementStateChangeListener = onSectionElementStateChangeListener;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public boolean isShouldShowAlert() {
        return shouldShowAlert;
    }

    protected void setShouldShowAlert(boolean shouldShowAlert) {
        this.shouldShowAlert = shouldShowAlert;
    }

    public boolean isHasStateIcon() {
        return hasStateIcon;
    }

    protected void setHasStateIcon(boolean hasStateIcon) {
        this.hasStateIcon = hasStateIcon;
    }

    @Override
    public Object getValue() {
        return sectionElementState.getValue();
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Integer) {
            sectionElementState = SectionElementState.fromInt((Integer) value);
        }
    }

    public boolean isBottomButtonReferenceSkipped() {
        return isBottomButtonReferenceSkipped;
    }

    protected void setBottomButtonReferenceSkipped(boolean bottomButtonReferenceSkipped) {
        isBottomButtonReferenceSkipped = bottomButtonReferenceSkipped;
    }

    public enum SectionElementState {
        LOCKED(0), OPENED(1), VIEWED(2), FILLED(3);
        int value;

        SectionElementState(int value) {
            this.value = value;
        }

        static SectionElementState fromInt(int i) {
            switch (i) {
                case 1:
                    return OPENED;
                case 2:
                    return VIEWED;
                case 3:
                    return FILLED;
                case 0:
                default:
                    return LOCKED;
            }
        }

        public int getValue() {
            return value;
        }
    }

    public interface OnSectionElementStateChangeListener {
        void onSectionElementStateChange(SectionEvaluationItem sectionEvaluationItem);
    }
}
