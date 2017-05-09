package com.szg_tech.hearthfailure.core.views.cell;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import com.szg_tech.hearthfailure.R;
import com.szg_tech.hearthfailure.core.views.CustomTextView;

public class DatePickerCell extends LinearLayout implements CellItem {
    CustomTextView textView;
    DatePicker datePicker;

    public DatePickerCell(Context context) {
        super(context);
        inflate(context);
    }

    public DatePickerCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public DatePickerCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public DatePickerCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }

    public void inflate(Context context) {
        inflate(context, R.layout.date_picker_cell, this);
        initView();
    }

    private void initView() {
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        textView = (CustomTextView) findViewById(R.id.name);
        setUpView();
    }

    public void setUpView() {
        datePicker.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(View.GONE);
        datePicker.setMaxDate(System.currentTimeMillis());
    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

    @Override
    public void setHintText(String text) {

    }

    public DatePicker getDatePicker() {
        return datePicker;
    }
}
