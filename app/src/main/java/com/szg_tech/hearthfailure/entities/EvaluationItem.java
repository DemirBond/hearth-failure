package com.szg_tech.hearthfailure.entities;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class EvaluationItem implements Serializable {
    protected transient Context context;
    protected String name;
    protected String id;
    private String hint;
    private boolean isMandatory;
    private boolean isValid = true;

    protected EvaluationItem(Context context, String id, String name, String hint, boolean isMandatory) {
        this.context = context;
        this.name = name;
        this.id = id;
        this.hint = hint;
        this.isMandatory = isMandatory;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public String getName() {
        return name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getId() {
        return id;
    }

    public boolean isValid() {
        return isValid;
    }

    protected void setValid(boolean valid) {
        isValid = valid;
    }

    public abstract Object getValue();

    public abstract void setValue(Object value);

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return null;
    }
}
