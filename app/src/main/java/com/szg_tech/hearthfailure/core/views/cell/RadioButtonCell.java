package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class RadioButtonCell extends LinearLayout implements CellItem {
    View rootView;
    RadioButton radioButton;
    CustomTextView textView;
    ImageView nextArrow;

    public RadioButtonCell(Context context) {
        super(context);
        inflate(context);
    }

    public RadioButtonCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public RadioButtonCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public RadioButtonCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }

    public void inflate(Context context) {
        inflate(context, R.layout.radio_button_view, this);
        initView();
    }

    public void initView() {
        rootView = findViewById(R.id.root_view);
        radioButton = (RadioButton) findViewById(R.id.radio);
        textView = (CustomTextView) findViewById(R.id.name);
        nextArrow = (ImageView) findViewById(R.id.chevron_fwd);
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    public void setChecked(boolean isChecked) {
        radioButton.setChecked(isChecked);
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    @Override
    public void setHintText(String text) {

    }

    public void showNextArrow() {
        nextArrow.setVisibility(VISIBLE);
    }

    public void setBackgroundHighlighted(boolean isBackgroundHighlighted) {
        if (isBackgroundHighlighted) {
            rootView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.section_bg_highlight));
        } else {
            rootView.setBackgroundColor(Color.WHITE);
        }
    }
}
