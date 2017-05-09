package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class SectionPlaceholderCell extends LinearLayout implements CellItem {
    private CustomTextView textView;
    private CustomTextView placeHolderView;

    public SectionPlaceholderCell(Context context) {
        super(context);
        inflate(context);
    }

    public SectionPlaceholderCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public SectionPlaceholderCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public SectionPlaceholderCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.section_placeholder_cell, this);
        initView();
    }

    private void initView() {
        textView = (CustomTextView) findViewById(R.id.name);
        placeHolderView = (CustomTextView) findViewById(R.id.placeholder);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {
        placeHolderView.setHint(text);
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

}
