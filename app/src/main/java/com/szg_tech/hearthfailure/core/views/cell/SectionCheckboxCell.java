package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class SectionCheckboxCell extends LinearLayout implements CellItem {
    private CustomTextView textView;
    private CheckBox checkBox;

    public SectionCheckboxCell(Context context) {
        super(context);
        inflate(context);
    }

    public SectionCheckboxCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public SectionCheckboxCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public SectionCheckboxCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.section_checkbox_cell, this);
        initView();
    }

    private void initView() {
        textView = (CustomTextView) findViewById(R.id.name);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public boolean isChecked() {
        return checkBox.isChecked();
    }

    public void setChecked(boolean isChecked) {
        checkBox.setChecked(isChecked);
    }
}