package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class CheckBoxCell extends LinearLayout implements CellItem {
    View rootView;
    CheckBox checkBox;
    CustomTextView textView;

    public CheckBoxCell(Context context) {
        super(context);
        inflate(context);
    }

    public CheckBoxCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public CheckBoxCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public CheckBoxCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }

    public void inflate(Context context) {
        inflate(context, R.layout.check_box_view, this);
        initView();
    }

    public void initView() {
        rootView = findViewById(R.id.root_view);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        textView = (CustomTextView) findViewById(R.id.name);
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    public void setChecked(boolean isChecked) {
        checkBox.setChecked(isChecked);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    @Override
    public void setHintText(String text) {

    }

    public void setBackgroundHighlighted(boolean isBackgroundHighlighted) {
        if (isBackgroundHighlighted) {
            rootView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.section_bg_highlight));
        } else {
            rootView.setBackgroundColor(Color.WHITE);
        }
    }
}
